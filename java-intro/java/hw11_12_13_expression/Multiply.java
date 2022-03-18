package hw11_12_13_expression;

import java.math.BigDecimal;

public class Multiply extends BinaryOperation {
    public Multiply(Child left, Child right) {
        super(left, right, "*");
    }

    @Override
    public int eval(int left, int right) {
        return left * right;
    }

    @Override
    public BigDecimal eval(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Multiply) &&
                ((Multiply) other).left.equals(this.left)
                && ((Multiply) other).right.equals(this.right);
    }

    @Override
    public Type getType() {
        return Type.MULTIPLY;
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public boolean isAssociative() {
        return true;
    }

    @Override
    public boolean mustWrap() {
        return false;
    }
}
