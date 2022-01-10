package PactStorge;

import java.util.ArrayList;

public class Pact {
    private ArrayList<Payment> paymentsList;
    private String number;
    private String date;

    public Pact(String number, String date)
    {
        this.number = number;
        this.date = date;
    }
    private void setDate(String date)
    {
        this.date = date;
    }   // если нужно будет, переделать в public
    private void setNumber(String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return number;
    }
    public String getDate()
    {
        return date;
    }
}
