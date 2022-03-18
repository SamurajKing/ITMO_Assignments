package hw11_12_13_expression.exceptions;

public class IllegalLogException extends ArithmException {

    public IllegalLogException(String s) {
        super(s);
    }
    public IllegalLogException() {
        super("Bad logarithm. Please check your operands.");
    }
}
