/*
 * Written by Anna Phan
 */
public class LLQueue <T> implements QueueI <T>{
    //T means that it is the generic type
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
    public LLQueue()
    {
        head = tail = null;
    }
    //returns nothing and takes in some generic data that is added to the end of the queue
    public void enqueue(T aData)
    {
        ListNode newNode = new ListNode(aData,null);
        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        tail.link = newNode;
        tail = tail.link;
    }
    //removes and returns the first element’s data of the queue as long as the head is not null
    public T dequeue()
    {
        if(head == null)
            return null;
        T ret = head.data;
        head = head.link;
        return ret;
    }
    //Returns the first element’s data but doesn’t remove the element
    public T peek()
    {
        if(head == null)
            return null;
        return head.data;
    }
    //Prints out the entire queue
    public void print()
    {
        ListNode temp = head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }
}
