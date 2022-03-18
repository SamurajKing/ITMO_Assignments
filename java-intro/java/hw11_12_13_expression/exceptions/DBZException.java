package hw11_12_13_expression.exceptions;

public class DBZException extends ArithmException {
    public DBZException(String s) {
        super(s);
    }

    public DBZException() {
        super("Division by zero exception!");
    }
}
