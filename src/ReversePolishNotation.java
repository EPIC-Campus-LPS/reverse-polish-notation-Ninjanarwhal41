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
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
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
        String output = "";
        Stack s = new Stack();
        String[] arr = input.split(" ");
        for(int i = 0; i < arr.length; i++){
            if (Character.isDigit(arr[i].charAt(0))){
                output += arr[i] + " ";
            }
            else{
              if (s.isEmpty()){
                  s.push(arr[i]);
                }
              else{
                  if (checkPrecedence(arr[i], s.peek()){
                      s.push(arr[i]);
                  }
                  else{
                      output += s.pop();
                  }
              }
            }
        }

        return output;
    }
    public static boolean checkPrecedence(String a, String b){
        int order = 0;
        int order2 = 0;
        switch (a){
            case "+", "-":
                order = 1;
                break;
            case "*", "/":
                order = 2;
                break;
            case "^":
                order = 3;
                break;
            case "(":
                order = 4;
                break;
        }
        switch (b){
            case "+", "-":
                order2 = 1;
                break;
            case "*", "/":
                order2 = 2;
                break;
            case "^":
                order2 = 3;
                break;
            case "(":
                order2 = 4;
                break;
        }
        return order > order2;
        //if the first one has higher precedence, return true
        //if the second one has higher precedence, return false.
    }
}
