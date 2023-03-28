/*
 * Written by Anna Phan
 */
import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class Showcase {

    // Instance variables
    private Prize[] prizeList;
    static Prize[] prizes = new Prize[5];

    // Parameterized Constructor
    public Showcase(Prize[] aP)
    {
        this.prizeList = aP;
    }

    // Making a list of 5 randomly chosen prizes
    public void makeShowcase()
    {
        int[] ret = new int[5];
        for(int i=0; i<5; i++)
        {
            boolean hasRandomNum = false;
            int random = 0;
            while(hasRandomNum == false)
            {
                hasRandomNum = true;
                random = (int) (Math.random() * prizeList.length);
                for(int j=0; j<i; j++)
                {
                    if(random == ret[j])
                    {
                        hasRandomNum = false;
                        break;
                    }
                }
            }
            ret[i] = random;
        }
        for(int i=0; i<5; i++)
        {
            prizes[i] =prizeList[ret[i]];
            System.out.println(prizes[i]);
        }
    }

    // Getting the sum of those 5 randomly chosen prizes
    public static int getPrizeSum()
    {
        int sum =0;
        for(int i=0; i<5; i++)
        {
            sum = sum + prizes[i].getCost();
        }
        return sum;
    }

}
