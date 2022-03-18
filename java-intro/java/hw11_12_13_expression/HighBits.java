package hw11_12_13_expression;

import java.math.BigDecimal;

public class HighBits extends UnaryOperation {
    public HighBits(Child child) {
        super(child, "l0");
    }

    @Override
    public int eval(int x) {
        return Integer.numberOfLeadingZeros(x);
    }

    @Override
    public BigDecimal eval(BigDecimal x) {
        return null;
    }

    @Override
    public Type getType() {
        return Type.HIGH_BITS;
    }

    @Override
    public int getPriority() {
        return 3;
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
