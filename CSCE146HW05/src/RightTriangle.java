/*
 * Written by Anna Phan
 */
public class RightTriangle extends Shape{
    //Instance variables
    private double side1;
    private double side2;
    //Default Constructor
    public RightTriangle()
    {
        super();
        this.side1 = 0;
        this.side2 = 0;
    }
    //Parameterized Constructor
    public RightTriangle(String aT, double aA, double s1, double s2)
    {
        super(aT, aA);
        this.setSide1(s1);
        this.setSide2(s2);
    }
    //Accessors
    public double getSide1()
    {
        return this.side1;
    }
    public double getSide2()
    {
        return this.side2;
    }
    //Mutators
    public void setSide1(double s1)
    {
        if(s1 >=0.0)
            this.side1 = s1;
    }
    public void setSide2(double s2)
    {
        if(s2 >=0.0)
            this.side2 = s2;
    }
    //finds the area
    public void area(double s1, double s2)
    {
        setArea((s1*s2)/2);
    }
    //toString method
    public String toString()
    {
        return super.toString()+" Side 1: "+this.side1+" Side 2: "+this.side2+" Area: "+getArea();
    }
}
