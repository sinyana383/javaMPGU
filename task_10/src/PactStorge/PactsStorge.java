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
        Pact newPact = new Pact(number, date);
        if(getPact(number) != null)
            throw new IllegalArgumentException("number is not unique");
        pactsList.add(newPact);
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
