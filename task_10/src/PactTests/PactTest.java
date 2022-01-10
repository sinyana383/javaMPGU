package PactTests;


import PactStorge.*;
import org.junit.*;

public class PactTest extends Assert {
    @Test
    public void newPact_validArgs_newOk()
    {
        Pact pact = new Pact("123", "20130323");
        assertEquals(pact.getNumber(), "123");
        assertEquals(pact.getDate(), "20130323");
    }
}
