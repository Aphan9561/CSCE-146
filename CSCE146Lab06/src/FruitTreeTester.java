/*
 * Written by Anna Phan
 */
import java.util.Scanner;
import java.io.*;

public class FruitTreeTester {

    public static void main(String[] arg)
    {
        Scanner keyboard = new Scanner(System.in);
        //welcomes and prompt the user
        System.out.println("Welcome to the Fruit Tree! \nPlease enter a fruit file name");
        String name = keyboard.next();
        System.out.println("Populating tree file");

        LinkedBST<Fruit> tree = new LinkedBST<Fruit>();
        //reads the file
        try
        {
            Scanner fileScanner = new Scanner(new File(name));
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] split = line.split("\t");
                if(split.length == 2)
                {
                    String type =  split[0];
                    double weight = Double.parseDouble(split[1]);
                    Fruit f = new Fruit(type,weight);
                    tree.add(f);
                }
            }
            fileScanner.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //prints to console
        System.out.println("Printing the in-order traversal\n");
        tree.printInOrder();
        System.out.println("Printing the pre-order traversal\n");
        tree.printPreOrder();
        System.out.println("Printing the post-order traversal\n");
        tree.printPostOrder();
        System.out.println("Deleting Apple 0.4859853412170728\n");
        tree.remove(new Fruit("Apple",0.4859853412170728));
        System.out.println("Printing the in-order traversal\n");
        tree.printInOrder();
    }
}
