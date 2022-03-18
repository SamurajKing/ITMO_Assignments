package hw11_12_13_expression.exceptions;

public class OverflowException extends ArithmException {
    public OverflowException(String s) {
        super(s);
    }
    public OverflowException() {
        super("Overflow exception!");
    }
}
