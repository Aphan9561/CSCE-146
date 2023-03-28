/*
 * Written by Anna Phan
 */
public class LLQueue <T> implements QueueI <T>{
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
    private int qSize;
    public LLQueue()
    {
        head = tail = null;
        qSize = 0;
    }
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
        qSize++;
    }
    public T dequeue()
    {
        if(head == null)
            return null;
        T ret = head.data;
        head = head.link;
        qSize--;
        return ret;
    }
    public T peek()
    {
        if(head == null)
            return null;
        return head.data;
    }
    public void print()
    {
        for(ListNode temp = head; temp != null; temp = temp.link)
            System.out.println(temp.data);
    }
    public int size()
    {
        return this.qSize;
    }
}
