package PactTests;
import PactStore.*;
import org.junit.*;

import java.util.ArrayList;

public class PactTest extends Assert {
    @Test
    public void addPactToList_validArgs_newCorrectPactOk()
    {
        PactsStore pactsStore = new PactsStore();

        pactsStore.addPactToList("123", "20130701");
        Pact pact = pactsStore.getPact("123");
        assertEquals("123", pact.getNumber());
        assertEquals("20130701", pact.getDate());
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

        pactsStore.addPayment
                (100, 1, "1", "123", "20131231");
        Payment newPayment = pactsStore.getPact("123").getPaymentsList().get(0);
        assertEquals(100, newPayment.getAmount());
        assertEquals(1, newPayment.getPaymentNumber());
        assertEquals("Платежное поручение", newPayment.getType());
        assertEquals("123", newPayment.getPactNumber());
        assertEquals("20131231", newPayment.getDate());
    }
    @Test
    public void addPayment_invalidArgs_throwsException()
    {
        PactsStore pactsStore = new PactsStore();

        var exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPayment
                        (100, 1, null, "123", "20131231"));
        assertEquals("payment type can't be null", exception.getMessage().toLowerCase());

        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPayment
                        (100, 1, "1", null, "20131231"));
        assertEquals("number and date can't be null", exception.getMessage().toLowerCase());

        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPayment
                        (100, 1, "1", "123", "20131232"));
        assertEquals("invalid date", exception.getMessage().toLowerCase());

        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPayment
                        (0, 1, "1", "123", "20131231"));
        assertEquals("the amount of money should be positive number", exception.getMessage().toLowerCase());

        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPayment
                        (-2, 1, "1", "123", "20131231"));
        assertEquals("the amount of money should be positive number", exception.getMessage().toLowerCase());
    }
    @Test
    public void addPayment_addTheSamePayment_throwsException()
    {
        PactsStore pactsStore = new PactsStore();

        pactsStore.addPayment
                (100, 1, "1", "123", "20131231");
        var exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.addPayment
                        (120, 1, "1", "123", "20131231"));
        assertEquals("payment with the same args is already exist", exception.getMessage().toLowerCase());
    }
    @Test
    public void deletePayments_deletePayments_completelyDeletedPayments()
    {
        PactsStore pactsStore = new PactsStore();

        pactsStore.addPayment
                (100, 1, "1", "123", "20131231");
        pactsStore.addPayment
                (100, 1, "2", "123", "20131231");
        pactsStore.addPayment
                (100, 2, "1", "123", "20131231");

        PactsStore expectedPactsStore = new PactsStore();
        expectedPactsStore.addPayment
                (100, 2, "1", "123", "20131231");
        ArrayList<Payment> expectedPayments = expectedPactsStore.getPact("123").getPaymentsList();

        pactsStore.deletePayments(1,  "123", "20131231");
        ArrayList<Payment> payments = pactsStore.getPact("123").getPaymentsList();
        assertEquals(1,payments.size());
        assertEquals(expectedPayments.size(),payments.size());
        assertEquals(expectedPayments.get(0).getPaymentNumber(), payments.get(0).getPaymentNumber());
    }
    @Test
    public void deletePayments_deleteNonexistentPayments_throwException()
    {
        PactsStore pactsStore = new PactsStore();

        pactsStore.addPayment
                (100, 1, "1", "123", "20131231");
        pactsStore.addPayment
                (100, 1, "2", "123", "20131231");
        pactsStore.addPayment
                (100, 2, "1", "123", "20131231");

        var exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.deletePayments(3,  "123", "20131231"));
                assertEquals("try to delete not existent payment", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.deletePayments(1,  "12", "20131231"));
        assertEquals("try to delete not existent payment", exception.getMessage().toLowerCase());
        exception = assertThrows
                (IllegalArgumentException.class, () -> pactsStore.deletePayments(1,  "123", "20131230"));
        assertEquals("try to delete not existent payment", exception.getMessage().toLowerCase());

    }

    @Test
    public void findAllPaymentsByPactNumberAndNumber_existentAndNonexistentPactsWithOrWithoutPayments_nullOrArrayListReturn()
    {
        PactsStore pactsStore = new PactsStore();

        pactsStore.addPayment
                (100, 1, "1", "123", "20210113");
        pactsStore.addPayment
                (100, 1, "1", "123", "20210213");
        assertEquals(2, pactsStore.findAllPaymentsByPactNumberAndNumber("123", 1).size());
        assertEquals("20210113", pactsStore.findAllPaymentsByPactNumberAndNumber("123", 1).get(0).getDate());
        assertEquals("20210213", pactsStore.findAllPaymentsByPactNumberAndNumber("123", 1).get(1).getDate());
        assertNull(pactsStore.findAllPaymentsByPactNumberAndNumber("1234", 1));

        pactsStore = new PactsStore();
        pactsStore.addPayment
                (100, 2, "1", "12345", "20210113");
        pactsStore.deletePayments(2, "12345", "20210113");
        assertNotNull(pactsStore.getPact("12345"));
        assertNull(pactsStore.findAllPaymentsByPactNumberAndNumber("12345", 2));
    }

    @Test
    public void returnAllPayments_differentPactsStores_nullOrList()
    {
        PactsStore pactsStore = new PactsStore();

        pactsStore.addPayment
                (100, 1, "1", "123", "20131231");
        pactsStore.addPayment
                (100, 1, "2", "123", "20131231");
        pactsStore.addPayment
                (100, 2, "1", "123", "20131231");

        assertEquals(3, pactsStore.returnAllPayments().size());

        pactsStore.addPactToList("1234", "20200904");
        assertEquals(3, pactsStore.returnAllPayments().size());

        pactsStore = new PactsStore();
        pactsStore.addPactToList("1234", "20200904");
        assertNull(pactsStore.returnAllPayments());

        pactsStore = new PactsStore();
        assertNull(pactsStore.returnAllPayments());
    }
}
