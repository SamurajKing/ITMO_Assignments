package hw11_12_13_expression.exceptions;

public class IncorrectContinueException extends RuntimeException {
    public IncorrectContinueException(String s) {
        super(s);
    }
    public IncorrectContinueException() {
        super("Incorrect continue!");
    }
}
