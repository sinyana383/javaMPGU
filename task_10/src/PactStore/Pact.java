package PactStore;

import java.util.ArrayList;

public class Pact extends Document{
    private ArrayList<Payment> paymentsList;

    public Pact(String number, String date)
    {
        super(number, date);
        paymentsList = new ArrayList<>();
    }

    private void setDate(String date)
    {
        this.date = date;
    }   // если нужно будет, переделать в public
    private void setNumber(String number)
    {
        this.number = number;
    }
    public void addNewPayment(Payment newPayment)
    {
        paymentsList.add(newPayment);
    }

    public String getNumber()
    {
        return number;
    }
    public String getDate()
    {
        return date;
    }
    public ArrayList<Payment> getPaymentsList()
    {
        return paymentsList;
    }
}
