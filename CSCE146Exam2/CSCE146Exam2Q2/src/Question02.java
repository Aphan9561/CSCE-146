/*
 * Anna Phan
 * CSCE 146 S2022 Exam02 Question02
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question02
{
    public class Node //public for testing purposes
    {
        private Book data;
        private Node leftChild;
        private Node rightChild;
        public Node(Book aData)
        {
            this.data = aData;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    public Node root; //public for testing purposes
    public void add(Book aData)
    {
//-----------------------------------------------------------------------------------
        //Write your solution here
        if(root == null)
            root = new Node(aData);
        else
            add(root,aData);
    }//Do not alter this


    //Do not alter-----------------------------------------------------------------------
    public Book getBookWithMostWords()
    {
//-----------------------------------------------------------------------------------
        //Write your solution here
        return getBookWithMostWords(root);//puts the tree into the method
    }//Do not alter this


    //Write additional methods or properties here
    private Node add(Node aNode, Book aData) //Adds the to tree
    {
        if(aNode == null)
            aNode= new Node(aData);
        else if(aData.getWordCount() < aNode.data.getWordCount()) //Go left
            aNode.leftChild = add(aNode.leftChild, aData);
        else if(aData.getWordCount() > aNode.data.getWordCount()) //Go right
            aNode.rightChild = add(aNode.rightChild, aData);
        return aNode;
    }
    private Book getBookWithMostWords(Node aNode)//Finds the greatest value in the tree
    {
        if(aNode.rightChild == null)//checks the rightChild bc it's where the largest number will be
            return aNode.data;
        else
            return getBookWithMostWords(aNode.rightChild);
    }
    //--------------------------------------------------------------------------------
//Do not alter------------------------------------------------------------------------
    public void printPreorder()
    {
        printPreorder(root);
    }
    private void printPreorder(Node aNode)
    {
        if(aNode == null)
        {
            System.out.print("leaf, ");
            return;
        }
        System.out.print(aNode.data+", ");
        printPreorder(aNode.leftChild);
        printPreorder(aNode.rightChild);
    }
    //-----------------------------------------------------------------------------------
    //Test your code here. You may alter this as needed.
    public static void main(String[] args)
    {
        System.out.println("Adding books to book tree");
        Book[] books = {new Book(800),
                new Book(600),
                new Book(400),
                new Book(200),
                new Book(100),
                new Book(700),
                new Book(500),
                new Book(3000)};
        Question02 tree = new Question02();
        for(Book b: books)
            tree.add(b);
        System.out.println("Printing the preorder traversal of books");
        tree.printPreorder();

        System.out.println("\nThe book with the most words is: "+tree.getBookWithMostWords());

    }
    //--------------------------------------------------------------------------------
}//Do not alter this

/*Solution Description
 *
 */
