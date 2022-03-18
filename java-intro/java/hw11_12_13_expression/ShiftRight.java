package hw11_12_13_expression;

import java.math.BigDecimal;

public class ShiftRight extends BinaryOperation {
    public ShiftRight(Child left, Child right) {
        super(left, right, ">>");
    }

    @Override
    public int eval(int left, int right) {
        return left >> right;
    }

    @Override
    public BigDecimal eval(BigDecimal left, BigDecimal right) {
        return null;
    }

    @Override
    public Type getType() {
        return Type.SHIFT_RIGHT;
    }

    @Override
    public int getPriority() {
        return 0;
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
