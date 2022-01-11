package PactStore;

public abstract class Document {
     protected String number;
     protected String date;

    private boolean checkDateFormat(String date)
    {
        if(date.length() != 8)
            return false;
        for(int i = 0; i < date.length(); ++i) // все символы числа
        {
            if (date.charAt(i) < '0' || date.charAt(i) > '9')
                return false;
        }
        if(Integer.parseInt(date.substring(4,6)) > 12)
            return false;
        if(Integer.parseInt(date.substring(6,8)) > 31) // пока общая проверка
            return false;
        return true;
    }
     public Document(String number, String date)
     {
         if(number == null || date == null)
             throw new IllegalArgumentException("number and date can't be null");
         if(number.equals(""))
             throw new IllegalArgumentException("number can't be empty string");
         if(!checkDateFormat(date))
             throw new IllegalArgumentException("invalid date");
         this.number = number;
         this.date = date;
     }
}
