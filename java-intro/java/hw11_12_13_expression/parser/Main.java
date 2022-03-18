package hw11_12_13_expression.parser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        System.out.println(new ExpressionParser().parse(str).toMiniString());
    }
}
