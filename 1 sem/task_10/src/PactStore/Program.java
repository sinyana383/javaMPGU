package PactStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void addPact_1(PactsStore pactsStore)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер договора: ");
            String number = scanner.nextLine();
            System.out.println("Введите дату(строка формата \"YYYYMMDD\", где Y - год, M - месяц, D - день");
            String date = scanner.nextLine();
            pactsStore.addPactToList(number, date);
            System.out.println("Пакет номер: " + number + " успешно добавлен");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void addPayment_2(PactsStore pactsStore)
    {
        try {
        Scanner scanner = new Scanner(System.in);
        int amount = 0;
        int paymentNumber = 0;

        System.out.println("Введите сумму(целое положительное число): ");
        if(scanner.hasNextInt())
            amount = scanner.nextInt();
        else
        {
            System.out.println("Платёж НЕ добавлен: неверный ввод аргументов");
            return;
        }
        System.out.println("Введите номер платежа(целое положительное число): ");
        if(scanner.hasNextInt())
            paymentNumber = scanner.nextInt();
        else
        {
            System.out.println("Платёж НЕ добавлен: неверный ввод аргументов");
            return;
        }
        scanner.nextLine(); // nextLine нашел \n
        System.out.println("Введите тип платежа(\"1\" - Платежное поручение; \"2\" - Банковский ордер): ");
        String paymentType = scanner.nextLine();
        System.out.println("Введите номер договора: ");
        String pactNumber = scanner.nextLine();
        System.out.println("Введите дату(строка формата \"YYYYMMDD\", где Y - год, M - месяц, D - день");
        String date = scanner.nextLine();
        pactsStore.addPayment(amount, paymentNumber, paymentType, pactNumber, date);
        System.out.println("Платёж номер " + paymentNumber + " добавлен");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }
    }

    public static void deletePayment_3(PactsStore pactsStore)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            int paymentNumber = 0;

            System.out.println("Введите номер платежа(целое положительное число): ");
            if (scanner.hasNextInt())
                paymentNumber = scanner.nextInt();
            else {
                System.out.println("Платёж НЕ удален: неверный ввод номера");
                return;
            }
            scanner.nextLine();
            System.out.println("Введите номер договора: ");
            String pactNumber = scanner.nextLine();
            System.out.println("Введите дату(строка формата \"YYYYMMDD\", где Y - год, M - месяц, D - день");
            String date = scanner.nextLine();
            pactsStore.deletePayments(paymentNumber, pactNumber, date);
            System.out.println("Платеж(и) номер " + paymentNumber + " удален(ы)");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }
    }

    public static void printPayments_4(PactsStore pactsStore)
    {
        try {
            if (pactsStore.returnAllPayments() == null) {
                System.out.println("Список платежных документов пуст");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер договора:");
            String pactNumber = scanner.nextLine();
            int paymentNumber;
            System.out.println("Введите номер платежа:");
            if(scanner.hasNextInt())
                paymentNumber = scanner.nextInt();
            else
            {
                System.out.println("неверный ввод номера платежа");
                return;
            }
            ArrayList<Payment> payments = pactsStore.findAllPaymentsByPactNumberAndNumber(pactNumber, paymentNumber);
            outPayments(payments);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void printAllPayments_5(PactsStore pactsStore)
    {
        try {
            if (pactsStore.returnAllPayments() == null) {
                System.out.println("Список платежных документов пуст");
                return;
            }
            outPayments(pactsStore.returnAllPayments());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void outPayments(ArrayList<Payment> payments)
    {
        for (Payment payment : payments) {
            System.out.println("Номер Договора: " + payment.getPactNumber());
            System.out.println("Номер Платежа: " + payment.getPaymentNumber());
            System.out.println("Дата: " + payment.getDate());
            System.out.println("Тип: " + payment.getType());
            System.out.println("Сумма: " + payment.getAmount());
            System.out.println();
        }
    }

    public static void mainOutput()
    {
        System.out.println("/// МЕНЮ ///");
        System.out.println("ДОБАВЛЕНИЕ ДОГОВОРА = введите 1");
        System.out.println("ДОБАВЛЕНИЕ ПЛАТЁЖНОГО ДОКУМЕНТА = введите 2");
        System.out.println("УДАЛИТЬ ПЛАТЁЖНЫЙ ДОКУМЕНТ = введите 3");
        System.out.println("ПОИСК ПЛОТЕЖНЫХ ДОКУМЕНТОВ ПО ДОГОВОРУ = введите 4");
        System.out.println("СПИСОК ВСЕХ ПЛОТЁЖНЫХ ДОКУМЕНТОВ = введите 5");
        System.out.println("ВЫХОД ИЗ ПРОГРАММЫ = введите 10");
    }

    public static void mainProgram()
    {
        Scanner scanner = new Scanner(System.in);
        PactsStore pactsStore = new PactsStore();

        mainOutput();
        String act = scanner.nextLine();
        while (!act.equals("10"))
        {
            switch (act)
            {
                case "1":
                    addPact_1(pactsStore);
                    break;
                case "2":
                    addPayment_2(pactsStore);
                    break;
                case "3":
                    deletePayment_3(pactsStore);
                    break;
                case "4":
                    printPayments_4(pactsStore);
                    break;
                case "5":
                    printAllPayments_5(pactsStore);
                    break;
                case "10":
                    System.out.println("Выход...");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Неверный ввод");
                    break;
            }
            System.out.println("Нажмите Enter чтобы продолжить");
            scanner.nextLine();
            mainOutput();
            act = scanner.nextLine();
        }
        System.out.println("Выход...");
    }

}
