package hw11_12_13_expression;

import java.math.BigDecimal;

public class ArithmeticShiftRight extends BinaryOperation {
    public ArithmeticShiftRight(Child left, Child right) {
        super(left, right);
        this.symbol = ">>>";
    }

    @Override
    public int eval(int left, int right) {
        return left >>> right;
    }

    @Override
    public BigDecimal eval(BigDecimal left, BigDecimal right) {
        return null;
    }

    @Override
    public Type getType() {
        return Type.ARITHM_SHIFT_RIGHT;
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
