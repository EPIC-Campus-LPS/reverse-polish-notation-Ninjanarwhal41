import java.util.*;
import java.lang.*;

public class ReversePolishNotation {
    public static int evaluatePostfix(String input){
        int result = 0;
        Stack s = new Stack();
        String[] arr = input.split(" ");
        for(int i = 0; i < arr.length; i++){
            if (Character.isDigit(arr[i].charAt(0))){
                s.push(arr[i]);
            }
            else
            {
                int num1 = Integer.parseInt(s.pop());
                int num2 = Integer.parseInt(s.pop());

                switch (arr[i]){
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                s.push(String.valueOf(result));
            }

        }
        if (s.size() > 1){
            throw new IllegalArgumentException("Invalid postfix expression.");
        }
        return result;

    }

    public static String infixtoPostfix(String input){
        return null;
    }
}
