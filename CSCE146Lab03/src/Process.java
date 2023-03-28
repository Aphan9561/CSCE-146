/*
 * Written by Anna Phan
 */
public class Process {
    //Instance Variables
    private String name;
    private double completionTime;
    //Default constructor
    public Process()
    {
        this.name = "no name yet";
        this.completionTime = 0.0;
    }
    //Parameterized constructors
    public Process(String aN, double cT)
    {
        this.setName(aN);
        this.setCompletionTime(cT);
    }
    //Accessors
    public String getName()
    {
        return this.name;
    }
    public double getCompletionTime()
    {
        return this.completionTime;
    }
    //Mutators
    public void setName(String aN)
    {
        this.name = aN;
    }
    public void setCompletionTime(double cT)
    {
        if(cT < 0.0)
            this.completionTime = 0.0;
        else
            this.completionTime = cT;
    }
    public String toString()
    {
        return "Process Name: "+this.name+" Completion Time: "+this.completionTime;
    }
}
