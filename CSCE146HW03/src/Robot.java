/*
 * Written by Anna Phan
 */
import java.io.*;
import java.util.Scanner;
public class Robot {

    //Instance Variables
    public static final int MAZE_SIZE = 10;
    public static final int OBST_AMT = (MAZE_SIZE*MAZE_SIZE)/10;
    char [][] board;
    public static final char EMPTY = '_';
    public static final char PLAYER = 'O';
    public static final char OBST = 'X';

    public static final String RIGHT = "Move Right";
    public static final String LEFT = "Move Left";
    public static final String DOWN = "Move Down";
    public static final String UP = "Move Up";

    private int [] currLoc;
    public boolean hitWall;

    //Makes the queue
    private LLQueue<String> queue;

    //Parameterized Constructors
    public Robot(String rC2, String rC)
    {
        queue = new LLQueue<String>();
        board = readBoard(rC2);
        readCommand(rC);
        board[0][0] = PLAYER;
        currLoc = new int[] {0,0};
        hitWall = false;
    }
    public char[][] readBoard(String fileName) //read the board
    {
        try
        {
            Scanner fileScanner = new Scanner(new File(fileName));
            int wordCount = 0;
            while(fileScanner.hasNextLine())
            {
                String sym = fileScanner.nextLine();
                wordCount++;
            }
           if(wordCount <= 0)
               return null;
           char [][] retArr = new char[MAZE_SIZE][MAZE_SIZE];
           fileScanner = new Scanner(new File(fileName));
           for(int i = 0;i<MAZE_SIZE;i++)
           {
               String line = fileScanner.nextLine();
               for(int j = 0;j<MAZE_SIZE;j++)
               {
                   retArr[i][j] = line.charAt(j);
               }
           }
           return retArr;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public void readCommand(String rFile)//reads the commands
    {
        try
        {
            Scanner fileScanner = new Scanner(new File(rFile));
            int wordCount = 0;
            fileScanner = new Scanner(new File(rFile));
            while(fileScanner.hasNextLine())
            {
                queue.enqueue(fileScanner.nextLine());
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void print()//prints the board
    {
        for(int i =0; i< board.length;i++)
        {
            for(int j = 0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public void CommandAction(String input)
    {
        board[currLoc[0]][currLoc[1]] = EMPTY;
        int currY = currLoc[0];
        int currX = currLoc[1];
        int[] copyLoc = {currLoc[0], currLoc[1]};
        if(input.equalsIgnoreCase(UP))//Moves the robot up
        {
            if(isValid(currY - 1) && board[currY-1][currX] != OBST)
            {
                currLoc[0]--;
            }
            else
            {
                System.out.println("Invalid move");
                hitWall = true;
            }
        }
        else if(input.equalsIgnoreCase(DOWN))//Moves the robot down
        {
            if(isValid(currY + 1) && board[currY+1][currX] != OBST)
            {
                currLoc[0]++;
            }
            else
            {
                System.out.println("Invalid move");
                hitWall = true;
            }
        }
        else if(input.equalsIgnoreCase(LEFT))//Moves the robot left
        {
            if(isValid(currX - 1) && board[currY][currX-1] != OBST)
            {
                currLoc[1]--;
            }
            else
            {
                System.out.println("Invalid move");
                hitWall = true;
            }
        }
        else if(input.equalsIgnoreCase(RIGHT))//Moves the robot right
        {
            if(isValid(currX + 1) && board[currY][currX+1] != OBST)
            {
                currLoc[1]++;
            }
            else
            {
                System.out.println("Invalid move");
                hitWall = true;
            }
        }
        else
        {
            System.out.println("Invalid move");
            hitWall = true;
        }
        board[currLoc[0]][currLoc[1]] = PLAYER;
    }
    private boolean isValid(int index)
    {
        return index >= 0 && index < board.length;
    }
    public int getSize()
    {
        return queue.size();
    }
    public String getCurrent()
    {
        return queue.dequeue();
    }
}
