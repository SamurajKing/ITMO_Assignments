package hw11_12_13_expression.exceptions;

public class Main {
    public static void main(String[] args) {
        System.out.println(new ExpressionParser().parse("(x+)").toString());
    }
}
