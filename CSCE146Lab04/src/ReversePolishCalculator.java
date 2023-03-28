/*
 * Written by Anna Phan
 */
import java.util.*;
public class ReversePolishCalculator {
    private LLStack<String> valueStack;
    public ReversePolishCalculator()
    {
        valueStack = new LLStack<String>();
    }
    public int calculate(String input)
    {
        Scanner keyboard = new Scanner(input);
        valueStack = new LLStack<>();
        int n1, n2;
        int value = 0;
        String result = "";
        String p = "";
        String isNumber = "0123456789";
        String isOperator = "+-*/";
        String isSpace = " \t";
        while(keyboard.hasNext())
        {
            String curr = keyboard.next();
            if(isNumber.contains(curr)) // checks for the number
            {
                valueStack.push(curr);
            }
            else if(isOperator.contains(curr)) // checks for the operator
            {
                if(!isValid())
                    return 0;
                if(curr.equals("+")) // add the numbers
                {
                    n2 = Integer.parseInt(valueStack.pop());
                    n1 = Integer.parseInt(valueStack.pop());
                    value = n1 + n2;
                    result = p + value;
                    valueStack.push(result);
                }
                else if(curr.equals("-")) //Subtracts the numbers
                {
                    n2 = Integer.parseInt(valueStack.pop());
                    n1 = Integer.parseInt(valueStack.pop());
                    value = n1 - n2;
                    result = p + value;
                    valueStack.push(result);
                }
                else if(curr.equals("*")) // multiples the numbers
                {
                    n2 = Integer.parseInt(valueStack.pop());
                    n1 = Integer.parseInt(valueStack.pop());
                    value = n1 * n2;
                    result = p + value;
                    valueStack.push(result);
                }
                else if(curr.equals("/")) //divides the numbers
                {
                    n2 = Integer.parseInt(valueStack.pop());
                    if(n2 == 0)
                    {
                        System.out.println("Cannot divide by zero.");
                        return 0;
                    }
                    n1 = Integer.parseInt(valueStack.pop());
                    value = n1 / n2;
                    result = p + value;
                    valueStack.push(result);
                }
                else
                {
                    System.out.println("Not an operator");
                }
            }
            else if(isSpace.contains(curr)) // checks for spaces
            {
                continue;
            }
            else
            {
                System.out.println("Not a valid operator.");
                return 0;
            }
        }
        //If there are too many numbers and not enough operators
        if(valueStack.size() != 1)
        {
            System.out.println("This was not properly formatted. There were too many numbers and not enough operators.");
            return 0;
        }
        return Integer.parseInt(valueStack.pop());
    }
    public boolean isValid() // checks if the stack has a valid size
    {
        if(valueStack.size() >= 2)
        {
            return true;
        }
        else if(valueStack.size() == 1)
        {
            System.out.println("This was not properly formatted. There were too many operators and not enough numbers.");
            return false;
        }
        else if(valueStack.size() < 1)
        {
            System.out.println("This was not properly formatted. There were too many numbers and not enough operators.");
            return false;
        }
        return false;
    }
}
