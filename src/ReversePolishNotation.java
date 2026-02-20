import java.util.*;
import java.lang.*;

public class ReversePolishNotation {
    /**
     * evaluates a postfix expression.
     * @param input a given postfix expression with spaces between characters
     * @return the result of the postfix expression.
     */
    public static int evaluatePostfix(String input){
        int result = 0;
        Stack s = new Stack();
        String[] arr = input.split(" ");
        for(int i = 0; i < arr.length; i++){
            if (Character.isDigit(arr[i].charAt(0)) || (arr[i].charAt(0) == '-' && arr[i].length() > 1)){
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

    /** translates a given expression to reverse polish (postfix) notation
     * @param input a given infix expression separated by spaces (except parentheses)
     * @return the expression in postfix form
     */
    public static String infixtoPostfix(String input){
        String output = "";
        input = input.replace("(", "( ");
        input = input.replace(")", " )");
        String[] chars = input.split(" ");
        Stack s = new Stack();
        for(int i = 0; i < chars.length; i++){
            String symbol = chars[i];
            if (symbol.equals("(")){
                s.push(symbol);
            }
            else if (Character.isDigit(symbol.charAt(0)) || (symbol.charAt(0) == '-' && symbol.length() > 1))
            {
                output += symbol + " ";
            }
            else if (symbol.equals(")")) {
                while (!s.isEmpty() && !s.peek().equals("(")){
                    output += s.pop() + " ";
                }
                s.pop();
            }
            else {
                while (!s.isEmpty() && checkPrecedence(s.peek()) >= checkPrecedence(symbol)){
                    output += s.pop() + " ";
                }
                s.push(symbol);
            }
        }
        while (!s.isEmpty()){
            output += s.pop() + " ";
        }
        return output;
    }
    public static int checkPrecedence(String a){
        int order = 0;
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
        }
        return order;
        // returns a value for precedence of an operator.
    }
}
