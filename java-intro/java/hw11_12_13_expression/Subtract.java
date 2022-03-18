package hw11_12_13_expression;

import java.math.BigDecimal;

public class Subtract extends BinaryOperation {
    public Subtract(Child left, Child right) {
        super(left, right, "-");
    }

    @Override
    public int eval(int left, int right) {
        return left - right;
    }

    @Override
    public BigDecimal eval(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Subtract) &&
                ((Subtract) other).left.equals(this.left)
                && ((Subtract) other).right.equals(this.right);
    }

    @Override
    public Type getType() {
        return Type.SUBTRACT;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean isAssociative() {
        return false;
    }

    @Override
    public boolean mustWrap() {
        return false;
    }

}
