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

        Pact pact = getPact(newPayment.getPactNumber());
        if(pact == null)    // если нет договора, он создается на дату первой платежки
        {
            addPactToList(pactNumber, date);
            pact = getPact(newPayment.getPactNumber());
        }
        pact.addNewPayment(newPayment);
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
    public int getSize()
    {
        if(pactsList != null)
            return pactsList.size();
        return 0;
    }

}
