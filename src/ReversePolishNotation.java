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
        for(int i = 0; i < input.length(); i++){
            String symbol = input.substring(i, i + 1);
            char simbol = symbol.charAt(0);
            if (symbol.equals(" ")){
                continue;
            }
            if (symbol.equals("(")){
                s.push(symbol);
            }
            else if (Character.isDigit(simbol))
            {
                output += symbol;
            }
            else if (symbol.equals(")")) {
                s.push(symbol);
                while (!s.isEmpty() && !s.peek().equals("(")){
                    output += s.pop();
                }
                s.pop();
            }
            else {
                while (!s.isEmpty() && checkPrecedence(s.peek()) >= checkPrecedence(symbol)){
                    output += s.pop();
                }
                s.push(symbol);
            }
        }
        return output;
    }
    public static int checkPrecedence(String a){
        int order = 0;
        switch (a){
            case "+", "-":
                order = 3;
                break;
            case "*", "/":
                order = 2;
                break;
            case "^":
                order = 1;
                break;
        }
        return order;
        // returns a value for precedence of an operator.
    }
}
