/*
 * Written by Anna Phan
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShowcaseShowdown {
    // Picking what file to read from
    public static final String FILE_NAME = "./prizeList.txt";

    // Making a Showcase
    private static Scanner keyboard = new Scanner(System.in);
    private static Showcase game;

    // Front End of the Game
    public static void main(String[] args) {
        System.out.println("Welcome to the Showcase Showdown!");
        boolean gameOver = false;
        while(gameOver == false)
        {
            System.out.println("Your prizes are: ");
            game = new Showcase(readFile(FILE_NAME));
            game.makeShowcase();
            System.out.println("How much do you these five prizes are worth?");
            int cost = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("");
            if(cost > (game.getPrizeSum()-3500) && cost < (game.getPrizeSum()+3500))
            {
                System.out.println("Your answer was "+cost+". The actual value was $"+game.getPrizeSum()+
                        "\nYou are correct and very close! You win!");
            }
            else
            {
                System.out.println("Your guess was "+cost+". The actual value was $"+game.getPrizeSum()+
                        "\nYour guess are incorrect. You lost.");
            }

            // Repeats if the user wants it to
            System.out.println("Would you like to play again? Enter \"no\" to quit");
            String answer = keyboard.nextLine();
            if(answer.equalsIgnoreCase("no"))
            {
                // Stops loop if user want to "quit"
                gameOver = true;
                break;
            }
            System.out.println();
        }
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public static final String DELIM = "\t";

    // reads from the chosen file
    public static Prize[] readFile(String fileName)
    {
        try
        {
            // Checks how many prizes are in the correct format
            int lineCount =0;
            Scanner fileScanner = new Scanner(new File(fileName));
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] splitLines = line.split("\t");
                if(splitLines.length == 2)
                {
                    lineCount ++;
                }
            }

            //Creates a scanner for the file and then first counts each word
            fileScanner.close();
            Prize[] p = new Prize[lineCount];
            fileScanner = new Scanner(new File(fileName));
            int counter = 0;
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] splitLines = line.split(DELIM);
                if(splitLines.length == 2)
                {
                    String name = splitLines[0];
                    int price = Integer.parseInt(splitLines[1]);
                    Prize aPrize = new Prize(name, price);
                    p[counter] = aPrize;
                    counter++;
                }
            }
            fileScanner.close();

            return p;
        }

        // Catches exceptions so the code doesn't freak out
        catch(IOException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

}
