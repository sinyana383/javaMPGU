package PactStore;

import java.util.ArrayList;

public class PactsStore {
    private ArrayList<Pact> pactsList;

    public PactsStore()
    {
        pactsList = new ArrayList<>();
    }

    public void addPactToList(String number, String date)
    {
        Pact newPact = new Pact(number, date);
        if(getPact(number) != null)
            throw new IllegalArgumentException("number is not unique");
        pactsList.add(newPact);
    }
    public void addPayment(int amount, int paymentNumber, String payType, String pactNumber, String date)
    {
        Payment newPayment = new Payment(amount, paymentNumber, payType, pactNumber, date);

        ArrayList<Payment> similarPayments = getPaymentListByNumberAndDate(paymentNumber, pactNumber, date);
        if(similarPayments != null)
        {
            for (Payment payment : similarPayments)
            {
                if (payment.getType().equals(newPayment.getType()))
                    throw new IllegalArgumentException("payment with the same args is already exist");
            }
        }
        Pact pact = getPact(newPayment.getPactNumber());
        if(pact == null)    // если нет договора, он создается на дату первой платежки
        {
            addPactToList(pactNumber, date);
            pact = getPact(newPayment.getPactNumber());
        }
        pact.addNewPayment(newPayment);
    }
    public void deletePayments(int paymentNumber, String pactNumber, String date)
    {
        ArrayList<Payment> paymentsToDelete = getPaymentListByNumberAndDate(paymentNumber, pactNumber, date);
        if(paymentsToDelete == null)
            throw new IllegalArgumentException("try to delete not existent payment");
        for(Payment payment : paymentsToDelete)
            getPact(pactNumber).deletePayment(payment);
    }
    public ArrayList<Payment> findAllPaymentsByPactNumberAndNumber(String pactNumber, int paymentNumber)
    {
        if(getPact(pactNumber) == null)
            return null;
        ArrayList<Payment> payments = getPact(pactNumber).getPaymentsList();
        if(payments.size() == 0)
            return null;
        ArrayList<Payment> resList = new ArrayList<>();
        for(Payment payment : payments)
        {
            if(payment.getPaymentNumber() == paymentNumber)
                resList.add(payment);
        }
        if(resList.size() == 0)
            return null;
        return resList;
    }

    public Pact getPact(String number)
    {
        if(pactsList == null)
            return null;
        for (Pact pact : pactsList) {
            if (pact.getNumber().equals(number))
                return pact;
        }
        return null;
    }
    public ArrayList<Payment> getPaymentListByNumberAndDate(int paymentNumber, String pactNumber, String date)
    {
        Pact pact = getPact(pactNumber);
        ArrayList<Payment> payments = new ArrayList<>();


        if(pact == null)
            return null;
        for(Payment payment : pact.getPaymentsList())
        {
            if (payment.getPaymentNumber() == paymentNumber && payment.getDate().equals(date))
                payments.add(payment);
        }

        if(payments.size() == 0)
            return null;
        return payments;
    }

    public ArrayList<Pact> getPaymentListByNumber() {
        return pactsList;
    }

    public int getSize()
    {
        if(pactsList != null)
            return pactsList.size();
        return 0;
    }
}
