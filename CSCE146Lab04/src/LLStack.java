/*
 * Written by Anna Phan
 */
public class LLStack <T> implements StackI <T>{
    private class ListNode
    {
        T data;
        ListNode link;
        public ListNode(T aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
        }
    }
    private ListNode head;
    private ListNode tail;
    private int StackSize;
    //Takes in data
    public LLStack()
    {
        head = null;
        this.StackSize = 0;
    }
    //Adds the data to the stack
    public void push(T aData)
    {
        ListNode newNode = new ListNode(aData, head);
        head = tail = newNode;
        StackSize++;
    }
    //Removes the data from the stack
    public T pop()
    {
        if(head == null)
            return null;
        T ret = head.data;
        head = head.link;
        StackSize--;
        return ret;
    }
    //Is "looking" at the stack
    public T peek()
    {
        if(head == null)
            return null;
        return head.data;
    }
    //Prints out the stack
    public void print()
    {
        for(ListNode temp = head; temp != null; temp = temp.link)
            System.out.println(temp.data);
    }
    //Keep track of the size of the stack
    public int size()
    {
        return StackSize;
    }
}
