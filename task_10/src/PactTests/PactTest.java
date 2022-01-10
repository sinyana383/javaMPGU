package PactTests;
import PactStorge.*;
import org.junit.*;

import java.util.Locale;

public class PactTest extends Assert {
    @Test
    public void addPactToList_validArgs_newCorrectPactOk()
    {
        PactsStorge pactsStorge = new PactsStorge();

        pactsStorge.addPactToList("123", "20131231");
        Pact pact = pactsStorge.getPact("123");
        assertEquals("123", pact.getNumber());
        assertEquals("20131231", pact.getDate());
        assertEquals(1,pactsStorge.getSize());
    }
    @Test
    public void addPactToList_invalidArgs_throwsException()
    {
        PactsStorge pactsStorge = new PactsStorge();

        var exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStorge.addPactToList(null, "20130323"));
        assertEquals("number and date can't be null", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStorge.addPactToList("123", null));
        assertEquals("number and date can't be null", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStorge.addPactToList("", "20130323"));
        assertEquals("number can't be empty string", exception.getMessage().toLowerCase());

        //INVALID DATE// будет время - добавить проверку дней по месяцам
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStorge.addPactToList("123", "2013"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStorge.addPactToList("123", "2013"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStorge.addPactToList("123", "2013132a"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStorge.addPactToList("123", "20131327"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStorge.addPactToList("123", "20131132"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
    }
}
