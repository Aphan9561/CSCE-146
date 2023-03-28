/*
 * Written by Anna Phan
 */
import java.util.Scanner;
public class RobotFE {

    public static void main(String[] arg)
    {
        Scanner keyboard=  new Scanner(System.in);
        //greets the user
        System.out.println("Welcome to the Robot Simulator");
        boolean again = true;
        do
        {
            System.out.println("Enter file for the board. \nOptions are: \"board.txt\" or \"board2.txt\"");
            String board = keyboard.nextLine();
            System.out.println("Enter file for the robot commands. \nOptions are : \"robotCommands.txt\", \"robotCommands2.txt\", or \"robotCommandsBad.txt\"");
            String commands = keyboard.nextLine();
            Robot rob = new Robot(board,commands);
            //prints out the beginning of the board
            rob.print();

            //Start of the simulation
            System.out.println("Simulation begin");

            while(rob.getSize() > 0 && rob.hitWall == false)
            {
                rob.CommandAction(rob.getCurrent());
                rob.print();
                System.out.println();
            }
            //End of the simulation
            System.out.println("Simulation end");

            //Ask is the user wants to play again
            System.out.println("Enter \"true\" to run another simulation or enter \"false\" to quit.");
            again = keyboard.nextBoolean();
            keyboard.nextLine();
        }
        while(again);
        System.out.println("Goodbye");

        keyboard.close();
    }
}
