/*
 * Written by Anna Phan
 */
import java.io.*;
import java.util.Scanner;

public class ShapeTreeTester {

    static Scanner keyboard = new Scanner(System.in);
    static LinkedBST<Shape> tree = new LinkedBST<Shape>();

    public static void main(String[] arg) throws IOException {
        System.out.println("Welcome to the Shape Tree \nPlease enter a shape file name");
        String name = keyboard.next();
        System.out.println("Populating tree file\n");
        tree.readFile(name);
        boolean again = true;
        do
        {
            System.out.println("\nWhat do you wish to do?" +
                    "\nEnter 1 to print per-order traversal" +
                    "\nEnter 2 to print in-order traversal" +
                    "\nEnter 3 to print post-order" +
                    "\nEnter 4 to add to the file" +
                    "\nEnter 5 to remove from file" +
                    "\nEnter 6 to remove a value that is greater then" +
                    "\nEnter 7 to write shape file" +
                    "\nEnter 8 to search for a shape" +
                    "\nEnter 9 to find shape with max area" +
                    "\nEnter 0 to quit");
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            switch(choice)
            {
                case 1: //prints pre order
                    System.out.println("\nPrinting the pre-order traversal\n");
                    tree.printPreOrder();
                    break;
                case 2: //prints in order
                    System.out.println("\nPrinting the in-order traversal\n");
                    tree.printInOrder();
                    break;
                case 3: //prints post order
                    System.out.println("\nPrinting the post-order traversal\n");
                    tree.printPostOrder();
                    break;
                case 4: //add shape to tree
                    addShape(tree);
                    break;
                case 5://remove shape from tree
                    System.out.println("Enter the type of shape");
                    String shape = keyboard.nextLine();
                    System.out.println("Enter the area of shape");
                    double area = keyboard.nextDouble();
                    keyboard.nextLine();
                    Shape delete = new Shape(shape, area);
                    tree.remove(delete);
                    System.out.println("\nPrinting the in-order traversal \n");
                    tree.printInOrder();
                    break;
                case 6: //remove shapes tha tare greater then value enter
                    System.out.println("Enter value");
                    double greater = keyboard.nextDouble();
                    tree.removeGreaterThan(greater);
                    System.out.println("Printing the in-order traversal\n");
                    tree.printInOrder();
                    break;
                case 7: //prints tree to text file
                    System.out.println("Enter the file name to write the shape file");
                    String fileName = keyboard.nextLine();
                    tree.writeFile(fileName);
                    break;
                case 8: //search for shape
                   searchShape();
                   break;
                case 9: //finds max area and prints it out
                    System.out.println("The max area is "+tree.maxArea());
                    break;
                case 0: //quits program
                    again = false;
                    break;
                default: //if wrong input is entered
                    System.out.println("Invalid Input");
            }
        }
        while(again);
        System.out.println("Goodbye");
    }
    //add shape to tree
    public static void addShape(LinkedBST tree)
    {
        System.out.println("Enter name shape. Options are \"Rectangle\", \"Right Triangle\", or \"Circle\".");
        String sName = keyboard.nextLine();
        if(sName.equalsIgnoreCase("Rectangle"))
        {
            System.out.println("Enter the first side.");
            double rs1 = keyboard.nextDouble();
            keyboard.nextLine();
            System.out.println("Enter the second side.");
            double rs2 = keyboard.nextDouble();
            keyboard.nextLine();
            Rectangle rec = new Rectangle(sName, 0,rs1, rs2);
            rec.area(rec.getSide1(),rec.getSide2());
            tree.add(rec);
        }
        else if(sName.equalsIgnoreCase("Right Triangle"))
        {
            System.out.println("Enter the first side.");
            double rts1 = keyboard.nextDouble();
            keyboard.nextLine();
            System.out.println("Enter the second side.");
            double rts2 = keyboard.nextDouble();
            keyboard.nextLine();
            RightTriangle rt = new RightTriangle(sName, 0 ,rts1, rts2);
            rt.area(rt.getSide1(),rt.getSide2());
            tree.add(rt);
        }
        else if(sName.equalsIgnoreCase("Circle"))
        {
            System.out.println("Enter the radius.");
            double cr = keyboard.nextDouble();
            keyboard.nextLine();
            Circle circle = new Circle(sName, 0, cr);
            circle.area(circle.getRadius());
            tree.add(circle);
        }
        else
        {
            System.out.println("That shape is invalid");
        }
        System.out.println("\nPrinting the in-order traversal \n");
        tree.printInOrder();
    }
    //search for shape
    public static void searchShape()
    {
        System.out.println("Enter name shape. Options are \"Rectangle\", \"Right Triangle\", or \"Circle\".");
        String type = keyboard.nextLine();
        if(type.equalsIgnoreCase("Rectangle"))
        {
            System.out.println("Enter the first side.");
            double rs1 = keyboard.nextDouble();
            keyboard.nextLine();
            System.out.println("Enter the second side.");
            double rs2 = keyboard.nextDouble();
            keyboard.nextLine();
            Rectangle rec = new Rectangle(type, 0,rs1, rs2);
            rec.area(rec.getSide1(),rec.getSide2());
            if(tree.search(rec) == true)
            {
                System.out.println("Shape found!");
                System.out.println(rec);
            }
            else
            {
                System.out.println("Shape does no exist");
            }
        }
        else if(type.equalsIgnoreCase("Right Triangle"))
        {
            System.out.println("Enter the first side.");
            double rts1 = keyboard.nextDouble();
            keyboard.nextLine();
            System.out.println("Enter the second side.");
            double rts2 = keyboard.nextDouble();
            keyboard.nextLine();
            RightTriangle rt = new RightTriangle(type, 0 ,rts1, rts2);
            rt.area(rt.getSide1(),rt.getSide2());
            if(tree.search(rt) == true)
            {
                System.out.println("Shape found!");
                System.out.println(rt);
            }
            else
            {
                System.out.println("Shape does no exist");
            }
        }
        else if(type.equalsIgnoreCase("Circle"))
        {
            System.out.println("Enter the radius.");
            double cr = keyboard.nextDouble();
            keyboard.nextLine();
            Circle circle = new Circle(type, 0, cr);
            circle.area(circle.getRadius());
            if(tree.search(circle) == true)
            {
                System.out.println("Shape found!");
                System.out.println(circle);
            }
            else
            {
                System.out.println("Shape does no exist");
            }
        }
        else
        {
            System.out.println("Shape is invalid");
        }
    }
}
