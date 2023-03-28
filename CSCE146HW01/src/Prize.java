/*
 * Written by Anna Phan
 */
public class Prize {
    // Private instance variables
    private String prizeName;
    private int cost;

    // Default Constructor
    public Prize()
    {
        this.prizeName = "none";
        this.cost = 0;
    }

    // Parameterized Constructor
    public Prize(String pN, int aP)
    {
        this.setPrizeName(pN);
        this.setCost(aP);
    }

    // Accessors for each instance variable
    public String getPrizeName()
    {
        return this.prizeName;
    }

    public int getCost()
    {
        return this.cost;
    }

    // Mutators for each instance variable
    public void setPrizeName(String pN)
    {
        if(pN != null)
        {
            this.prizeName = pN;
        }
        else
        {
            this.prizeName = "none";
        }
    }

    public void setCost(int aP)
    {
        if(aP < 0)
        {
            this.cost = 0;
        }
        else
        {
            this.cost = aP;
        }
    }

    // toString method
    public String toString()
    {
        return this.prizeName;
    }

    // equals method
    public boolean equals(Prize p)
    {
        return p != null &&
                this.prizeName.equals(p.getPrizeName()) &&
                this.cost == p.getCost();
    }

}
