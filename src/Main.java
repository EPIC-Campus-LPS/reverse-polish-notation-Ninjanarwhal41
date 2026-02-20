public class Main {
    public static void main(String[] args) {
        System.out.println(ReversePolishNotation.evaluatePostfix("7 2 + 9 / 3 5 * -"));
        System.out.println(ReversePolishNotation.evaluatePostfix("7 11 + 9 / 3 5 * -"));
        System.out.println(ReversePolishNotation.evaluatePostfix("-3 4 *"));
       // System.out.println(ReversePolishNotation.evaluatePostfix("+ * 2 3 - 4 5")); //in prefix notation, should throw an error
        System.out.println(ReversePolishNotation.infixtoPostfix("(7 + 2) / 9 - 3 * 5"));
        System.out.println(ReversePolishNotation.infixtoPostfix("(6 + 4) - 12 * 7 / (14 - 3)"));
        System.out.println(ReversePolishNotation.infixtoPostfix("(3 + (4 + 5))"));
        System.out.println(ReversePolishNotation.infixtoPostfix("(12 + 34) * (5 - 2) / 7 ^ 2"));
    }
}