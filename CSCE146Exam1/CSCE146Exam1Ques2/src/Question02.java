/*
 * Anna Phan
 * CSCE 146 Exam01 Question02
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 * Testing is encouraged but remove all testing code before turning it in.
 */
//Do not alter-----------------------------------------------------------------------
public class Question02
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
    public void insertDoubles()
    {
        if(head == null)
            return;
        current = head;//Points to hed as the current
        while(current != null )
        {
            int DD = current.data*2;//doubles the current integer
            addAfterCurrent(DD);//adds doubled integer after the current
            current = current.link.link;//goes to the integer after the doubled integer
        }
    }
    //Write additional methods or properties here

    public ListNode current;
    public void addAfterCurrent(int aData)
    {
        if(current == null)
            return;
        ListNode temp = current.link;
        ListNode newNode = new ListNode(aData,null);
        current.link = newNode;//the next node it the newNode
        newNode.link = temp;//the previous current.link is the temp element
    }

    //--------------------------------------------------------------------------------
    //Test your code here. You may alter this as needed.
    public static void main(String[] args)
    {
        //Example
        Question02 intLL = new Question02();
        intLL.head = intLL.new ListNode(0,
                intLL.new ListNode(1,
                        intLL.new ListNode(2,
                                intLL.new ListNode(3,
                                        intLL.new ListNode(4,null)))));
        intLL.insertDoubles();
        //Printing Results
        for(Question02.ListNode temp = intLL.head;temp != null; temp = temp.link)
            System.out.println(temp.data);
    }
    //--------------------------------------------------------------------------------
}//Do not alter this
