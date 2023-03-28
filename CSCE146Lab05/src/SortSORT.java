/*
 * Written by Anna Phan
 */
import java.util.Scanner;
import java.util.Stack;
public class SortSORT {
    public static void main(String [] arg)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean again = true;
        do
        {
            //Ask user for word list
            System.out.println("Enter any number of strings and I will sort by SORT’s. Once you’re done entering sentences enter \"quit\"");
            //Put list into an array
            String[] list = trueLength();

            mergeSort(list);

            System.out.println();
            //Prints out the sorted list
            System.out.println("sort SORTED!");
            for(int i =0; i<list.length;i++)
            {
                System.out.println(list[i]);
            }
            System.out.println();
            System.out.println("Would you like to sort more Strings? " +
                    "\nEnter \"true\" to sort again or \"false\" to stop.");
            again = keyboard.nextBoolean();
            keyboard.nextLine();
        }
        while(again);
        System.out.println("Goodbye");
    }
    public static String[] trueLength()
    {
        Scanner keyboard = new Scanner(System.in);

        String[] list = new String[100000];
        int k=0;

        while(true)
        {
            String word = keyboard.nextLine();

            if(word.equalsIgnoreCase("quit"))
            {
                break;
            }
            else
            {
                list[k]= word;
                k++;
            }
        }

        int counter=0;
        for(int i =0; i< list.length; i++)
        {
            if(list[i] != null)
            {
                counter++;
            }
        }

        String[] wordList = new String[counter];
        for(int i =0; i< wordList.length; i++)
        {
            wordList[i] = list[i];
        }

        return wordList;
    }

    // Takes in a String array, slits it into a left and right array, and calls the merge method
    public static void mergeSort(String [] a)
    {
        int size = a.length;

        if(size < 2)
        {
            return;
        }
        int mid = size/2;
        int leftSize = mid;
        int rigthSize = size - mid;
        String [] left = new String [leftSize];
        String [] right = new String [rigthSize];
        for(int i=0; i<mid; i++)
        {
            left[i] = a[i];
        }
        for(int i =mid; i<size; i++)
        {
            right[i-mid] = a[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, a);
    }

    /*
     * Takes in the string arrays from mergeSort, sorts them based of the number of 'sorts' and/or the word length,
     * and returns the newly sorted String array (in ascending order)
     */
    public static String [] merge(String[] left, String[] right, String[] a)
    {
        int leftSize = left.length;
        int rightSize = right.length;
        int b =0;
        int c =0;
        int k =0;

        int [] sortListLeft = new int[left.length];
        int [] tieBreakerLeft = new int[left.length];
        int [] sortListRight = new int[right.length];
        int [] tieBreakerRight = new int[right.length];
        int sortCount=0;
        for(int i =0; i< left.length; i++)
        {
            if(4 <= left[i].length())
            {
                for(int j = 0; j<= left[i].length() - 4; j++)
                {
                    if(left[i].substring(j,j+4).equalsIgnoreCase("sort"))
                    {
                        sortCount++;
                    }
                }
            }
            sortListLeft[i] = sortCount;
            tieBreakerLeft[i] = left[i].length();
            sortCount=0;
        }

        for(int i =0; i< right.length; i++)
        {
            if(4 <= right[i].length())
            {
                for(int j = 0; j<= right[i].length() - 4; j++)
                {
                    if(right[i].substring(j,j+4).equalsIgnoreCase("sort"))
                    {
                        sortCount++;
                    }
                }
            }
            sortListRight[i] = sortCount;
            tieBreakerRight[i] = right[i].length();
            sortCount=0;
        }

        while(b<leftSize && c<rightSize)
        {
            if(sortListLeft[b] <= sortListRight[c])
            {
                a[k] = left[b];
                b++;
                k++;
            }
            else if(sortListLeft[b] == sortListRight[c])
            {
                if(tieBreakerLeft[b] > tieBreakerRight[c])
                {
                    a[k] = left[b];
                    b++;
                    k++;
                }
            }
            else
            {
                a[k] = right[c];
                c++;
                k++;
            }
        }

        while(b < leftSize)
        {
            a[k] = left[b];
            b++;
            k++;
        }

        while(c < rightSize)
        {
            a[k] = right[c];
            c++;
            k++;
        }

        return a;

    }
}

