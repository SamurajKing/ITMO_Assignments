package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.Child;
import hw11_12_13_expression.Type;
import hw11_12_13_expression.UnaryOperation;

import java.math.BigDecimal;

public class CheckedAbs extends UnaryOperation {
    public CheckedAbs(Child child) {
        super(child, "abs");
    }

    @Override
    public Type getType() {
        return Type.ABS;
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public boolean isAssociative() {
        return false;
    }

    @Override
    public boolean mustWrap() {
        return false;
    }

    @Override
    public int eval(int x) {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return x > 0 ? x : -x;
    }

    @Override
    public BigDecimal eval(BigDecimal x) {
        return null;
    }
}
