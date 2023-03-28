/*
 * Written by Anna Phan
 */
import java.util.Locale;
import java.util.Scanner;
import java.io.*;
public class GameManager {
    public static final String DELIM = "\t";
    public static final int BODY_FIELD_AMT = 2;
    GenLL <Game> list = new GenLL<Game>();

    public void readFile(String file) //Read the file
    {
        try
        {
            Scanner fileScanner = new Scanner(new File(file));
            while(fileScanner.hasNextLine())
            {
                String fileLine = fileScanner.nextLine(); //read
                String[] splitLines = fileLine.split(DELIM); // split
                if(splitLines.length == BODY_FIELD_AMT)
                {
                    String name = splitLines[0];
                    String console = splitLines[1];
                    Game newGame = new Game(name,console);
                    list.add(newGame);
                }
            }
            fileScanner.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void writeFile(String file, String appeal,GenLL<Game> search) //Write the file
    {
        if(list == null || file == null)
            return;
        try
        {
            if(appeal.equalsIgnoreCase("true"))
            {
                PrintWriter fileWriter = new PrintWriter(new FileOutputStream(file));
                search.reset();
                while(search.moreToIterate())
                {
                    Game aGame = search.getCurrent();
                    fileWriter.println(aGame.getGName()+DELIM+aGame.getGConsole());
                    search.gotoNext();
                }
                fileWriter.close();
            }
            else if(appeal.equalsIgnoreCase("false"))
            {
                PrintWriter fileWriter = new PrintWriter(new FileOutputStream(file));
                list.reset();
                while(list.moreToIterate())
                {
                    Game aGame = list.getCurrent();
                    fileWriter.println(aGame.getGName()+DELIM+aGame.getGConsole());
                    list.gotoNext();
                }
                fileWriter.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public GenLL searchFile(String gName, String gConsole) //Search in file
    {
        GenLL <Game> searchResults = new GenLL<Game>();
        list.reset();
        while(list.moreToIterate())
        {
            if(gName.equalsIgnoreCase("*") && gConsole.equalsIgnoreCase("*"))
            {
                searchResults = list;
                break;
            }
            else if(gName.equalsIgnoreCase("*"))//Searches for console
            {
                String[] match = list.getCurrent().toString().split(DELIM);
                if(match[1].contains(gConsole))
                {
                    if(match.length == BODY_FIELD_AMT)
                    {
                        Game newGame = new Game();
                        newGame.setGName(match[0]);
                        newGame.setGConsole(match[1]);
                        searchResults.add(newGame);
                    }
                }
                list.gotoNext();
            }
            else if(gConsole.equalsIgnoreCase("*")) //Searches for name
            {
                String[] match = list.getCurrent().toString().split(DELIM);
                if (match[0].contains(gName))
                {
                    if(match.length == BODY_FIELD_AMT)
                    {
                        Game newGame = new Game();
                        newGame.setGName(match[0]);
                        newGame.setGConsole(match[1]);
                        searchResults.add(newGame);
                    }
                }
                list.gotoNext();
            }
            else//Searches for name and console
            {
                String[] match = list.getCurrent().toString().split(DELIM);
                if(match[1].contains(gConsole) && match[0].contains(gName))
                {
                    if(match.length == BODY_FIELD_AMT)
                    {
                        Game newGame = new Game();
                        newGame.setGName(match[0]);
                        newGame.setGConsole(match[1]);
                        searchResults.add(newGame);
                    }
                }
                list.gotoNext();
            }
        }
        return searchResults;
    }
}
