/*
 * <<YOUR NAME>>
 * CSCE 146 Exam01 Question03
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 * Testing is encouraged but remove all testing code before turning it in.
 */
//Do not alter-----------------------------------------------------------------------
public class Question03
{
    public class ListNode//public for testing purposes
    {
        public int data;//public for testing purposes
        public ListNode link;//public for testing purposes
        public ListNode(int aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
        }
    }
    public ListNode head;//public for testing purposes
//-----------------------------------------------------------------------------------
    //Write your method here
    public int getMinValue()
    {
        if(head == null)//making sure that the linked list is not null
            return 0;
        int min = 0;
        current = head;//Points to the head
        min = current.data;//
        while(current != null)
        {
            if(min > current.data) // compares the current integer with the next one
            {
                min = current.data;//seeing min as the integer that is less then the one before it
            }
            current = current.link;//pointing current to the next one
        }
        return min;
    }

    //Write additional methods or properties here

    public ListNode current;

    //--------------------------------------------------------------------------------
    //Test your code here. You may alter this as needed.
    public static void main(String[] args)
    {
        //Example
        Question03 intLL = new Question03();
        intLL.head = intLL.new ListNode(4,
                intLL.new ListNode(7,
                        intLL.new ListNode(5,
                                intLL.new ListNode(8,
                                        intLL.new ListNode(1,null)))));
        int min = intLL.getMinValue();
        System.out.println(min);
    }
    //--------------------------------------------------------------------------------
}//Do not alter this