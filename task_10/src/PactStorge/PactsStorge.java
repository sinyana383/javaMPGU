package PactStorge;

import java.util.ArrayList;

public class PactsStorge {
    private ArrayList<Pact> pactsList;
    public PactsStorge()
    {
        pactsList = new ArrayList<>();
    }

    public void addPactToList(String number, String date)
    {
        pactsList.add(new Pact(number, date));
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
    public int getPactsNumber()
    {
        if(pactsList != null)
            return pactsList.size();
        return 0;
    }
}
