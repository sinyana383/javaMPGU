package PactStore;

public class Payment extends Document {
    private int amount; //сумма
    private paymentType type;
    private int paymentNumber;

    public Payment(int amount, int paymentNumber, String payType, String pactNumber, String date)
    {
        super(pactNumber, date);
        if(amount <= 0)
            throw new IllegalArgumentException("the amount of money should be positive number");
        this.amount = amount;
        if(paymentNumber <= 0)
            throw new IllegalArgumentException("the number of payment should be positive number");
        this.paymentNumber = paymentNumber;
        if(payType == null)
            throw new IllegalArgumentException("payment type can't be null");
        if(payType.equals("1"))
            type = paymentType.PAYMENT_ORDER;
        else if(payType.equals("2"))
            type = paymentType.BANK_ORDER;
        else
            throw new IllegalArgumentException("wrong payment type name");
    }

    public String getPactNumber()
    {
        return number;
    }
    public int getPaymentNumber() {return paymentNumber;}
    public String getDate(){return date;}
    public int getAmount()
    {
        return amount;
    }
    public String getType()
    {
        return type.getRussianTitle();
    }
}

enum paymentType
{
    PAYMENT_ORDER("Платежное поручение"),
    BANK_ORDER("Банковский ордер");

    private String russianTitle;

    paymentType(String russianTitle)
    {
        this.russianTitle = russianTitle;
    }

    public String getRussianTitle()
    {
        return russianTitle;
    }
}