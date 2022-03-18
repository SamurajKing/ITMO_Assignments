package hw11_12_13_expression;

import java.math.BigDecimal;

public class UnaryMinus extends UnaryOperation {
    public UnaryMinus(Child child) {
        super(child, "-");
    }

    @Override
    public int eval(int x) {
        return -x;
    }

    @Override
    public BigDecimal eval(BigDecimal x) {
        return new BigDecimal("-1").multiply(x);
    }

    @Override
    public Type getType() {
        return Type.UNARY_MINUS;
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
