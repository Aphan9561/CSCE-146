/*
 * Anna Phan
 * CSCE 146 S2022 Exam02 Question01
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question01 {

    public static void sort(PepperoniPizza[] pizzas)
    {
//-----------------------------------------------------------------------------------	
        //Write your solution here
        // Takes in a String array
        int size = pizzas.length;
        if(size < 2)
            return;
        //slits it into a left and right array
        int mid = size/2;
        int leftSize = mid;
        int rigthSize = size - mid;
        PepperoniPizza [] left = new PepperoniPizza [leftSize];
        PepperoniPizza [] right = new PepperoniPizza [rigthSize];
        for(int i=0; i<mid; i++)
            left[i] = pizzas[i];
        for(int i =mid; i<size; i++)
            right[i-mid] = pizzas[i];
        //calls the merge method
        sort(left);
        sort(right);
        merge(left, right, pizzas);
    }//Do not alter this
    //Write any additional helper properties or methods here
    public static void merge(PepperoniPizza[] left, PepperoniPizza[] right, PepperoniPizza[] a) //Takes in the string arrays from sort
    {
        int leftSize = left.length;
        int rightSize = right.length;
        int i =0;
        int j =0;
        int k =0;
        //sorts them in descending order
        while(i<leftSize && j<rightSize)
        {
            if(left[i].getPepperonis() >= right[j].getPepperonis())
            {
                a[k] = left[i];
                i++;
                k++;
            }
            else
            {
                a[k] = right[j];
                j++;
                k++;
            }
        }
        while(i<leftSize)
        {
            a[k] = left[i];
            k++;
            i++;
        }
        while(j<rightSize)
        {
            a[k] = right[j];
            k++;
            j++;
        }
    }
    //--------------------------------------------------------------------------------
    //Test your code here. You may alter this as needed.
    public static void main(String[] args)
    {
        PepperoniPizza[] array = {new PepperoniPizza(10),
                new PepperoniPizza(5),
                new PepperoniPizza(3),
                new PepperoniPizza(1),
                new PepperoniPizza(8),
                new PepperoniPizza(6)};
        sort(array);
        for(PepperoniPizza w : array)
            System.out.println(w);
    }
    //--------------------------------------------------------------------------------
}//Do not alter this

/*Solution Description
 *
 */