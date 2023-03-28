/*
 * Written by Anna Phan
 */
public class Shape implements Comparable<Shape>{
    //Instance variables
    private String type;
    private double area;
    //Default Constructor
    public Shape()
    {
        this.type = "None";
        this.area = 0;
    }
    //Parameterized Constructor
    public Shape(String aT, double aA)
    {
        type = aT;
        this.setArea(aA);
    }
    //Accessors
    public String getType()
    {
        return this.type;
    }
    public double getArea()
    {
        return this.area;
    }
    //Mutators
    public void setType(String aT)
    {
        this.type = aT;
    }
    public void setArea(double aA)
    {
        if(aA >= 0)
            this.area = aA;
    }
    //compareTo method
    public int compareTo(Shape aShape)
    {
        if(area > aShape.area)
            return 1;
        else if(area < aShape.area)
            return  -1;
        else
            return 0;
    }
    //toString method
    public String toString()
    {
        return this.type;
    }
}
