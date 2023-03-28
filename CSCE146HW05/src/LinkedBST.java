/*
 * Written by Anna Phan
 */
import java.io.*;
import java.util.Scanner;
public class LinkedBST <T extends Shape>{

    private class Node
    {
        Shape data;
        Node leftChild;
        Node rightChild;
        public Node(Shape aData)
        {
            data = aData;
            leftChild = rightChild = null;
        }
    }
    private Node root;
    public LinkedBST()
    {
        root = null;
    }
    //adds to tree
    public void add(Shape aData)
    {
        if(root == null)
            root = new Node(aData);
        else
            add(root,aData);
    }
    private Node add(Node aNode, Shape aData)
    {
        if(aNode == null)
            aNode= new Node(aData);
        else if(aData.compareTo(aNode.data)<0)
            aNode.leftChild = add(aNode.leftChild, aData);
        else if(aData.compareTo(aNode.data)>0)
            aNode.rightChild = add(aNode.rightChild, aData);
        return aNode;
    }
    //remove from tree
    public void remove(Shape aData)
    {
        root = remove(root, aData);
    }
    private Node remove(Node aNode, Shape aData)
    {
        if(aNode == null)
            return null;
        else if(aData.compareTo(aNode.data)<0)
            aNode.leftChild = remove(aNode.leftChild, aData);
        else if(aData.compareTo(aNode.data)>0)
            aNode.rightChild = remove(aNode.rightChild, aData);
        else
        {
            if(aNode.rightChild == null)
                return aNode.leftChild;
            else if(aNode.leftChild == null)
                return aNode.rightChild;
            Node temp = findMinInTree(aNode.rightChild);
            aNode.data =temp.data;
            aNode.rightChild = remove(aNode.rightChild, aData);
        }
        return aNode;
    }
    private Node findMinInTree(Node aNode)
    {
        if(aNode == null)
            return null;
        else if(aNode.leftChild == null)
            return aNode;
        else
            return findMinInTree(aNode.leftChild);
    }
    //return true or false if that instance is found
    public boolean search(Shape aData)
    {
        return search(root, aData);
    }
    private boolean search(Node aNode, Shape aData)
    {
        if(aNode == null)
            return false;
        else if(aData.compareTo(aNode.data)<0)
            return search(aNode.leftChild, aData);
        else if(aData.compareTo(aNode.data)>0)
            return search(aNode.rightChild, aData);
        else
            return true;
    }
    //prints pre order
    public void printPreOrder()
    {
        printPreOrder(root);
    }
    private void printPreOrder(Node aNode)
    {
        if(aNode == null)
            return;
        System.out.println(aNode.data);
        printPreOrder(aNode.leftChild);
        printPreOrder(aNode.rightChild);
    }
    //prints in order
    public void printInOrder()
    {
        printInOrder(root);
    }
    private void printInOrder(Node aNode)
    {
        if(aNode == null)
            return;
        printInOrder(aNode.leftChild);
        System.out.println(aNode.data);
        printInOrder(aNode.rightChild);
    }
    //prints post order
    public void printPostOrder()
    {
        printPostOrder(root);
    }
    private void printPostOrder(Node aNode)
    {
        if(aNode == null)
            return;
        printPostOrder(aNode.leftChild);
        printPostOrder(aNode.rightChild);
        System.out.println(aNode.data);
    }
    //finds the max area
    public Shape maxArea()
    {
        return maxArea(root);
    }
    private Shape maxArea(Node aNode)
    {
        if(aNode.rightChild == null)
            return aNode.data;
        else
            return maxArea(aNode.rightChild);
    }
    //remove shapes
    public void removeGreaterThan(double gT)
    {
        removeGreaterThan(root, gT);
    }
    private Node removeGreaterThan(Node aNode, double gT)
    {
        if(aNode == null)
            return null;
        removeGreaterThan(aNode.leftChild, gT);
        removeGreaterThan(aNode.rightChild, gT);
        if(aNode.data.getArea() > gT){
            remove(aNode.data);
            return aNode;
        }
        return aNode;
    }
    //reads the file
    public static final String DELIM="\t";
    public void readFile(String fileName)
    {
        if(fileName==null)
            return;
        try
        {
            Scanner fileScanner = new Scanner(new File(fileName));
            String fileLine= fileScanner.nextLine();
            String[] splitLines=fileLine.split(DELIM);
            if(splitLines.length==3)
            {
                if(splitLines[0].equalsIgnoreCase("Rectangle"))
                {
                    Rectangle shape= new Rectangle(splitLines[0], 0, Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]));
                    shape.area(shape.getSide1(),shape.getSide2());
                    add(shape);
                    System.out.println(shape);
                }
                else if(splitLines[0].equalsIgnoreCase("Right Triangle"))
                {
                    RightTriangle shape= new RightTriangle(splitLines[0], 0, Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]));
                    shape.area(shape.getSide1(),shape.getSide2());
                    add(shape);
                    System.out.println(shape);
                }
                else if(splitLines[0].equalsIgnoreCase("Circle"))
                {
                    Circle shape= new Circle(splitLines[0], 0, Integer.parseInt(splitLines[1]));
                    shape.area(shape.getRadius());
                    add(shape);
                    System.out.println(shape);
                }
                else
                    System.out.println("invalid format");
            }
            else
            {
                System.out.println("Not valid format");
                return;
            }

            while(fileScanner.hasNextLine())
            {
                fileLine= fileScanner.nextLine();
                splitLines=fileLine.split(DELIM);
                if(splitLines.length==3 || splitLines.length==2){
                    if(splitLines[0].equalsIgnoreCase("Rectangle"))
                    {
                        Rectangle shape= new Rectangle(splitLines[0], 0, Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]));
                        shape.area(shape.getSide1(),shape.getSide2());
                        add(shape);
                        System.out.println(shape);
                    }
                    else if(splitLines[0].equalsIgnoreCase("Right Triangle"))
                    {
                        RightTriangle shape= new RightTriangle(splitLines[0], 0, Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]));
                        shape.area(shape.getSide1(),shape.getSide2());
                        add(shape);
                        System.out.println(shape);
                    }
                    else if(splitLines[0].equalsIgnoreCase("Circle"))
                    {
                        Circle shape= new Circle(splitLines[0], 0, Integer.parseInt(splitLines[1]));
                        shape.area(shape.getRadius());
                        add(shape);
                        System.out.println(shape);
                    }
                }
                else
                    System.out.println("Invalid format");

            }
            fileScanner.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return;
    }
    //prints file to text file
    public void writeFile(String aName)
    {
        try
        {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
            writeFile(root, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void writeFile(Node aNode, PrintWriter w)
    {
        if(aNode != null)
        {
            writeFile(aNode.leftChild, w);
            w.println(aNode.data);
            writeFile(aNode.rightChild, w);
        }
    }
}
