package hw11_12_13_expression.exceptions;

public class IndeterminacyException extends ArithmException {

    public IndeterminacyException(String s) {
        super(s);
    }
    public IndeterminacyException() {
        super("This expression is undefinable");
    }
}
