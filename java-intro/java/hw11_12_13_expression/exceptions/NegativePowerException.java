package hw11_12_13_expression.exceptions;

public class NegativePowerException extends ArithmException {
    public NegativePowerException(String s) {
        super(s);
    }
    public NegativePowerException() {
        super("Negative power exception!");
    }
}
