/*
 * Written by Anna Phan
 */
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
public class VideoGameFE {
    public static final String DELIM = "\t";
    private static GameManager manager;
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        GameManager games = new GameManager();
        System.out.println("Welcome to the Video game Database!");
        GenLL<Game> currentSearch = new GenLL<Game>();
        boolean quit = false;
        while(!quit)
        {
            System.out.println("Enter 1 to load video game database"+
                    "\nEnter 2 to search database " +
                    "\nEnter 3 to print the current results" +
                    "\nEnter 4 to print to a file" +
                    "\nEnter 9 to quit");
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            switch(choice)
            {
                case 1: // reads the file
                    System.out.println("Enter file name");
                    String fileName = keyboard.nextLine();
                    fileName = "Collection.txt";
                    games.readFile(fileName);
                    break;
                case 2: //Searches the file
                    System.out.println("Enter the name of the game or enter \"*\" for all the names");
                    String gName = keyboard.nextLine();
                    System.out.println("Enter the console of the game or enter \"*\" for all the consoles");
                    String gConsole = keyboard.nextLine();
                    games.searchFile(gName,gConsole).print();
                    currentSearch = games.searchFile(gName,gConsole);
                    break;
                case 3://Prints out results
                    currentSearch.print();
                    break;
                case 4://Prints to another file
                    System.out.println("Enter file name");
                    String file = keyboard.nextLine();
                    //Asking if user wants to print previous results to new file (true) or print file to another file(false)
                    System.out.println("Append? True or False");
                    String append = keyboard.nextLine();
                    games.writeFile(file,append, currentSearch);
                    break;
                case 9://Quits program
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        System.out.println("Goodbye");
    }
}
