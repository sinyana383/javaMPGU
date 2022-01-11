package PactTests;
import PactStore.*;
import org.junit.*;

public class PactTest extends Assert {
    @Test
    public void addPactToList_validArgs_newCorrectPactOk()
    {
        PactsStore pactsStore = new PactsStore();

        pactsStore.addPactToList("123", "20131231");
        Pact pact = pactsStore.getPact("123");
        assertEquals("123", pact.getNumber());
        assertEquals("20131231", pact.getDate());
        assertEquals(1, pactsStore.getSize());
    }
    @Test
    public void addPactToList_invalidArgs_throwsException()
    {
        PactsStore pactsStore = new PactsStore();

        var exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPactToList(null, "20130323"));
        assertEquals("number and date can't be null", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPactToList("123", null));
        assertEquals("number and date can't be null", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPactToList("", "20130323"));
        assertEquals("number can't be empty string", exception.getMessage().toLowerCase());

        //INVALID DATE// будет время - добавить проверку дней по месяцам
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPactToList("123", "2013"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPactToList("123", "2013"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPactToList("123", "2013132a"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPactToList("123", "20131327"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPactToList("123", "20131132"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());
    }
    @Test
    public void addPactToList_notUniqueNumber_throwsException()
    {
        PactsStore pactsStore = new PactsStore();
        pactsStore.addPactToList("123", "20131231");

        var exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPactToList("123", "20130323"));
        assertEquals("number is not unique", exception.getMessage().toLowerCase());
    }

    @Test
    public void addPayment_validArgs_newCorrectPaymentOk()
    {
        PactsStore pactsStore = new PactsStore();

        pactsStore.addPayment(100, 1, "Платежное поручение", "123", "20131231");
        Payment newPayment = pactsStore.getPact("123").getPaymentsList().get(0);
        assertEquals(100, newPayment.getAmount());
        assertEquals(1, newPayment.getPaymentNumber());
        assertEquals("Платежное поручение", newPayment.getType());
        assertEquals("123", newPayment.getPactNumber());
        assertEquals("20131231", newPayment.getDate());
    }
}
