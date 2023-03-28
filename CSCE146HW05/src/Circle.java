/*
 * Written by Anna Phan
 */
public class Circle extends Shape{
    //Instance variables
    private double radius;
    //Default Constructor
    public Circle()
    {
        super();
        this.radius = 0;
    }
    //Parameterized Constructor
    public Circle(String aT, double aA, double aR)
    {
        super(aT, aA);
        setRadius(aR);
    }
    //Accessors
    public double getRadius()
    {
        return this.radius;
    }
    //Mutators
    public void setRadius(double aR)
    {
        if(aR >= 0.0)
            this.radius = aR;
    }
    //finds the area
    public void area(double radius)
    {
        setArea(radius*radius*Math.PI);
    }
    //toString method
    public String toString()
    {
        return super.toString()+" Radius: "+this.radius+" Area: "+getArea();
    }
}
