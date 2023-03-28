/*
 * Anna Phan
 * CSCE 146 S2022 Exam01 Question03
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 */
//Do not alter------------------------------------------------------------------------
public class Question03
{
    private Candy[] heap = new Candy[10];
    public int size;//First null element

    public void add(Candy aData)
    {
//------------------------------------------------------------------------------------
        //Write your code here
        if(size >= heap.length)
            return;
        heap[size] = aData;
        bubbleUp();//puts in to a method to putting the instances in the correct location
        size++;//add to size
    }//Do not alter

    //Do not alter------------------------------------------------------------------------
    public Candy remove()
    {
//------------------------------------------------------------------------------------
        //Write your code here
        if(size == 0) //Return null is the tree is empty
            return null;
        Candy ret = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = null;
        size--;//remove from size
        bubbleDown();
        return ret;
    }//Do not alter

    //Write any additional helper properties or methods here
    private void bubbleUp()
    {
        //adding the new instance of Candy into the correct location
        int index = size;
        while(index > 0 && heap[(index-1)/2].compareTo(heap[index])>0)
        {
            Candy temp = heap[(index-1)/2];
            heap[(index-1)/2] = heap[index];
            heap[index] = temp;
            index = (index-1)/2;
        }
    }
    private void bubbleDown()
    {
        //remove by the number least to greatest
        int index = 0;
        while(index*2+1 < size)
        {
            int smallIndex = index*2+1;
            if(index*2+2 < size && heap[index*2+1].compareTo(heap[index*2+2])>0)
            {
                smallIndex = index*2+2;
            }
            if(heap[index].compareTo(heap[smallIndex])>0)
            {
                Candy temp = heap[index];
                heap[index] = heap[smallIndex];
                heap[smallIndex] = temp;
            }
            else
                break;
            index = smallIndex;
        }
    }
    //--------------------------------------------------------------------------------
//Do not alter------------------------------------------------------------------------

    public void printBreadthOrder()
    {
        for(Candy c : this.heap)
        {
            if(c != null)
                System.out.print(c+", ");
            else
                System.out.print("null, ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        System.out.println("Testing the Add Method");
        Candy[] array = {
                new Candy(100.0),
                new Candy(80.0),
                new Candy(60.0),
                new Candy(40.0),
                new Candy(20.0),
                new Candy(10.0),
                new Candy(30.0),
                new Candy(50.0),
                new Candy(70.0),
                new Candy(90.0)};
        Question03 heap = new Question03();
        for(Candy c : array)
            heap.add(c);
        heap.printBreadthOrder();

        System.out.println("Testing the Remove Method");
        for(int i=0;i<array.length;i++)
            System.out.print(heap.remove()+", ");
    }
    //--------------------------------------------------------------------------------

}//Do not alter
