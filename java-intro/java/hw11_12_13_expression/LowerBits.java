package hw11_12_13_expression;

import java.math.BigDecimal;

public class LowerBits extends UnaryOperation {
    public LowerBits(Child child) {
        super(child, "t0");
    }

    @Override
    public int eval(int x) {
        return Integer.numberOfTrailingZeros(x);
    }

    @Override
    public BigDecimal eval(BigDecimal x) {
        return null;
    }

    @Override
    public Type getType() {
        return Type.LOWER_BITS;
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
