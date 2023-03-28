/*
 * Written by Anna Phan
 */
public class DoubleDoubleLL{

    private class DListNode
    {
        double data;
        DListNode nextLink;
        DListNode prevLink;
        public DListNode(double adata, DListNode aNext, DListNode aPrev)
        {
            data = adata;
            nextLink = aNext;
            prevLink = aPrev;
        }
    }
    //Instant Variables
    private DListNode head;
    private DListNode current;

    public DoubleDoubleLL()
    {
        head = current = null;
    }
    public void gotoNext()//goes to the next node
    {
        if(current != null)
        {
            current = current.nextLink;
        }
    }
    public void gotoPrev()//goes to the previous node
    {
        if(current != null)
        {
            current = current.prevLink;
        }
    }
    public void reset()
    {
        current = head;
    }
    public void gotoEnd()//goes to end of the list
    {
        DListNode temp = head;
        while(temp.nextLink != null)
            temp = temp.nextLink;
        current = temp;
    }
    public boolean hasMore()
    {
        return current != null;
    }
    public double getCurrent()
    {
       if(current == null)
            return 0;
        return current.data;
    }
    public void setCurrent(double aData)
    {
        if(current==null)
            return;
        current.data = aData;
    }
    public void add(double aData)//add node at the end of the list
    {
        DListNode newNobe = new DListNode(aData, null, null);
        if(head == null)
        {
            head = current = newNobe;
            return;
        }
        DListNode temp = head;
        while(temp.nextLink != null)
            temp = temp.nextLink;
        temp.nextLink = newNobe;
        newNobe.prevLink = temp;
    }
    public void addAfterCurrent(double aData)
    {
        if(current == null)
            return;
        DListNode newNobe = new DListNode(aData, null,null);
        current = newNobe;
    }
    public void remove(double aData)
    {
        DListNode temp = head;
        while(temp != null)
        {
            if(temp.data == aData)
            {
                if(temp.prevLink == null)
                {
                    head = temp.nextLink;
                }
                else if(temp.nextLink == null)
                {
                    temp.prevLink.nextLink = null;
                    return;
                }
                else
                {
                    temp.prevLink.nextLink = temp.nextLink;
                    temp.nextLink.prevLink = temp.prevLink;
                    return;
                }
            }
            temp = temp.nextLink;
        }
    }
    public void removeCurrent()//Remove the current node that is at the current reference
    {
        if(current == null)
        {
            return;
        }
        if(current == head)
        {
            head = head.nextLink;
            current = head;
        }
        else
        {
            current.prevLink.nextLink = current.nextLink;
            current = current.nextLink;
        }
    }
    public void print()
    {
        DListNode temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.nextLink;
        }
    }
    public boolean contains(double aData)//returns true only if data provided via a parameter is contained in the list
    {
        DListNode temp = head;
        while(temp != null)
        {
            if(temp.data == aData)
            {
                return true;
            }
            temp = temp.nextLink;
        }
        return false;
    }
}
