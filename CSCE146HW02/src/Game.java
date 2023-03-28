/*
 * Written by Anna Phan
 */
public class Game {
    private String gName;
    private String gConsole;
    //Default Constructor
    public Game()
    {
        this.gName = "none";
        this.gConsole = "none";
    }
    //Parameterized Constructor
    public Game(String gN, String gC)
    {
        this.setGName(gN);
        this.setGConsole(gC);
    }
    //Accessor
    public String getGName()
    {
        return this.gName;
    }
    public String getGConsole()
    {
        return this.gConsole;
    }
    //Mutator
    public void setGName(String gN)
    {
        this.gName = gN;
    }
    public void setGConsole(String gC)
    {
        this.gConsole = gC;
    }
    //toString
    public String toString()
    {
        return this.gName+"\t"+this.gConsole;
    }
}
