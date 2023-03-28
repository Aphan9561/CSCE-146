/*
 * Anna Phan
 * CSCE 146 Exam01 Question01
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question01 {

//-----------------------------------------------------------------------------------	
    //Write your method here
    public static boolean largerComponents(int[] arr1, int [] arr2)
    {
        //Checks if one of the arrays is null and returns false if so
        if(arr1 == null || arr2 == null)
        {
            return false;
        }
        //Checks of the arrays are the same length
        else if(arr1.length == arr2.length)
        {
            for(int i =0; i< arr1.length;i++)
            {
                //Checks if arrays have the same integers or if array 1 is smaller then array 2
                if(arr1[i] == arr2[i] || arr1[i] < arr2[i])
                {
                    return false;//return false if the statement is true
                }
                //Returns true is array 1 is larger then array 2
                else if(arr1[i] > arr2[i])
                {
                    return true;//return true if the statement is true
                }
            }
        }
        return false;
    }

    //Write any additional helper properties or methods here

    //--------------------------------------------------------------------------------
    //Test your code here. You may alter this as needed.
    public static void main(String[] args)
    {

        int[] test01 = {1,2,3};
        int[] test02 = {1,2,3};

        System.out.println(largerComponents(test01,test02));
    }
    //--------------------------------------------------------------------------------
}//Do not alter this