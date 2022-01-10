package PactTests;
import PactStorge.*;
import org.junit.*;

public class PactTest extends Assert {
    @Test
    public void addPactToList_validArgs_newCorrectPactOk()
    {
        PactsStorge pactsStorge = new PactsStorge();

        pactsStorge.addPactToList("123", "20130323");
        Pact pact = pactsStorge.getPact("123");
        assertEquals(pact.getNumber(), "123");
        assertEquals(pact.getDate(), "20130323");
    }
}
