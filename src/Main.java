public class Main {
    public static void main(String[] args) {
        System.out.println(ReversePolishNotation.evaluatePostfix("7 2 + 9 / 3 5 * -"));
        System.out.println(ReversePolishNotation.evaluatePostfix("7 11 + 9 / 3 5 * -"));
        System.out.println(ReversePolishNotation.evaluatePostfix("7 2 + 9 / 3 5 -"));
    }
}