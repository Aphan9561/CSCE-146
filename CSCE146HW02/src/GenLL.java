/*
 * Written by Anna Phan
 */
public class GenLL <T>{

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
    ListNode head;
    ListNode current;
    ListNode previous;
    public GenLL()
    {
        head = current = previous = null;
    }
    public void add(T aData)//Adds node
    {
        ListNode newNode = new ListNode(aData,null);
        if(head == null)
        {
            head = new ListNode(aData,null);
            current = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.link != null)
            temp = temp.link;
        temp.link = newNode;
    }
    public void print()//prints node
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }
    public void gotoNext()//Goes to the next Node
    {
        if(current == null)
            return;
        previous = current;
        current = current.link;
    }
    public void reset()//Resets the list node
    {
        current = head;
        previous = null;
    }
    public T getCurrent()//gets to the current node
    {
        if(current== null)
            return null;
        return current.data;
    }
    public boolean moreToIterate()//making sure that current its not empty
    {
        return current != null;
    }
}
