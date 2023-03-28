/*
 *Written by Anna Phan
 */
import java.util.Scanner;
public class VectorMathProgram {

    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] arg) {
        printGreeting();
        boolean quit = false;
        while(!quit)
        {
            printChoices(); //The choices that are available fo teh user to choice from
            int choices = keyboard.nextInt();
            keyboard.nextLine();
            switch(choices)
            {
                case 1:
                    addVectors();
                    break;
                case 2:
                    subVector();
                    break;
                case 3:
                    magVector();
                    break;
                case 9:
                    System.out.println("Goodbye");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
    public static void printGreeting()
    {
        System.out.println("Welcome to the Vector Math program!");
    }
    public static void printChoices()
    {
        System.out.println("Enter 1 to add 2 vectors\n" +
                "Enter 2 to subtract 2 vectors\n" +
                "Enter 3 to find the magnitude of a vector\n" +
                "Enter 9 to quit");
    }
    public static void addVectors()
    {
        System.out.println("Enter the size of the vectors");
        int size = keyboard.nextInt();
        keyboard.nextLine();
        //Checking if the size not greater then or equal to 0
        while(size <= 0)
        {
            System.out.println("That size is invalid. Try again");
            size = keyboard.nextInt();
            keyboard.nextLine();
        }
        double [] v1 = new double[size];
        double [] v2 = new double[size];
        for(int i= 0;i<v1.length;i++)
        {
            System.out.println("Enter value "+(i+1)+" for vector 1");
            v1[i] = keyboard.nextDouble();
        }
        for(int i= 0;i<v2.length;i++)
        {
            System.out.println("Enter value "+(i+1)+" for vector 2");
            v2[i] = keyboard.nextDouble();
        }
        //Printing out the results
        System.out.println("Result");
        //Printing out the first vector
        for(int i = 0; i<v1.length;i++)
            System.out.println(v1[i]+" ");
        System.out.println("+");
        //Printing out the second vector
        for(int i = 0; i<v2.length;i++)
            System.out.println(v2[i]+" ");
        System.out.println("=");
        //Adding the two vectors and printing out the added vector
        double [] v3 = new double [size];
        for(int i = 0; i<size;i++)
            v3[i] = v1[i] + v2[i];
        for(int i = 0; i<v3.length;i++)
            System.out.println(v3[i]+" ");
    }
    public static void subVector()
    {
        System.out.println("Enter the size of the vectors");
        int size = keyboard.nextInt();
        keyboard.nextLine();
        //Checking if the size not greater then or equal to 0
        while(size <= 0)
        {
            System.out.println("That size is invalid. Try again");
            size = keyboard.nextInt();
            keyboard.nextLine();
        }
        double [] v1 = new double[size];
        double [] v2 = new double[size];
        for(int i= 0;i<v1.length;i++)
        {
            System.out.println("Enter value "+(i+1)+" for vector 1");
            v1[i] = keyboard.nextDouble();
        }
        for(int i= 0;i<v2.length;i++)
        {
            System.out.println("Enter value "+(i+1)+" for vector 2");
            v2[i] = keyboard.nextDouble();
        }
        //Printing out the results
        System.out.println("Result");
        //Printing out the first vector
        for(int i = 0; i<v1.length;i++)
            System.out.println(v1[i]+" ");
        System.out.println("-");
        //Printing out the second vector
        for(int i = 0; i<v2.length;i++)
            System.out.println(v2[i]+" ");
        System.out.println("=");
        //Subtracting the two vectors and printing out the subtracted vector
        double [] v3 = new double [size];
        for(int i = 0; i<size;i++)
            v3[i] = v1[i] - v2[i];
        for(int i = 0; i<v3.length;i++)
            System.out.println(v3[i]+" ");
    }
    public static void magVector()
    {
        System.out.println("Enter the size of the vector");
        int size = keyboard.nextInt();
        keyboard.nextLine();
        //Checking if the size not greater then or equal to 0
        while(size <= 0)
        {
            System.out.println("That size is invalid. Try again");
            size = keyboard.nextInt();
            keyboard.nextLine();
        }
        double [] vec = new double[size];
        for(int i= 0;i<vec.length;i++)
        {
            System.out.println("Enter value "+(i+1)+" for vector 1");
            vec[i] = keyboard.nextDouble();
        }
        double [] vecSqrt = new double[size]; //Array that will store the new vector values
        double sum = 0;
        for(int i =0; i<vec.length;i++)
        {
            vecSqrt[i] = Math.pow(vec[i],2); //Will square the values
            sum = sum + vecSqrt[i];//this will add up the squared values
        }
       // for(int i =0;i<vec.length;i++)
        for(int i =0;i<vec.length;i++) {
            double mag = Math.sqrt(sum);
            System.out.println("The magnitude is: " + mag);
        }
    }
}
