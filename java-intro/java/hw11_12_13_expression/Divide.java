package hw11_12_13_expression;

import java.math.BigDecimal;

public class Divide extends BinaryOperation {

    public Divide(Child left, Child right) {
        super(left, right, "/");
    }

    @Override
    public int eval(int left, int right) {
        return left / right;
    }

    @Override
    public BigDecimal eval(BigDecimal left, BigDecimal right) {
        return left.divide(right);
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Divide) &&
                ((Divide) other).left.equals(this.left)
                && ((Divide) other).right.equals(this.right);
    }


    @Override
    public Type getType() {
        return Type.DIVIDE;
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public boolean isAssociative() {
        return false;
    }

    @Override
    public boolean mustWrap() {
        return true;
    }
}
