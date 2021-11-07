package task;

public class Triangle {
    // поля
    private double a;
    private double b;
    private double c;

    // конструктор
    public Triangle(double a, double b, double c)
    {
        this.a = a; // this.a - объект структуры a - input от пользователя
        this.b = b;
        this.c = c;
    }

    //методы
    //  аксессоры
    public double getA()
    {
        return a;
    }
    public double getB()
    {
        return b;
    }
    public double getC()
    {
        return c;
    }

    public boolean isValid()
    {
        if(a + b <= c)
            return false;
        if(a + c <= b)
            return false;
        if(b + c <= a)
            return false;
        return true;
    }

    public double perimeter()
    {
        if(!(this.isValid()))
            return -1;
        return a + b + c;
    }
    public double square()
    {
        if(!(this.isValid()))
            return -1;
        double p = this.perimeter() / 2;
        return Math.sqrt(p*(p - a)*(p - b)*(p - c));
    }
}
