/*
 * Written by Anna Phan
 */
public class Fruit implements Comparable<Fruit>{
    //Instance Variables
    private String type;
    private double weight;
    //Default Constructor
    public Fruit()
    {
        this.type = "apple";
        this.weight = 1.0;
    }
    //Parameterized Constructor
    public Fruit(String aT, double aW)
    {
        this.setType(aT);
        this.setWeight(aW);
    }
    //Accessors
    public String getType()
    {
        return this.type;
    }
    public double getWeight()
    {
        return this.weight;
    }
    //Mutators
    public void setType(String aT)
    {
        if(aT.equalsIgnoreCase("apple") || aT.equalsIgnoreCase("orange") ||
                aT.equalsIgnoreCase("banana") || aT.equalsIgnoreCase("kiwi") ||
                aT.equalsIgnoreCase("tomato"))
            this.type = aT;
        else
            this.type = "Apple";
    }
    public void setWeight(double aW)
    {
        if(aW > 0.0)
            this.weight = aW;
        else
            this.weight = 1.0;
    }
    //toString method
    public String toString()
    {
        return this.type+" "+this.weight;
    }
    //compareTo method
    public int compareTo(Fruit aF)
    {
        if(aF == null)
            return 0;
        if(this.weight > aF.getWeight())
            return 1;
        else if(this.weight < aF.getWeight())
            return -1;
        else
            return 0;
    }

}
