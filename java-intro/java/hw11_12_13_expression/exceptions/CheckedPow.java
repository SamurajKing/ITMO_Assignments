package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.BinaryOperation;
import hw11_12_13_expression.Child;
import hw11_12_13_expression.Const;
import hw11_12_13_expression.Type;

import java.math.BigDecimal;

public class CheckedPow extends BinaryOperation {
    public CheckedPow(Child left, Child right) {
        super(left, right, "**");
    }

    public CheckedPow(Child left, Child right, String symbol) {
        super(left, right, symbol);
    }

    @Override
    public int eval(int left, int right) {
        //left ** right
        if (right < 0) {
            throw new NegativePowerException();
        }
        if (left == 0 && right == 0) {
            throw new IndeterminacyException("0 power 0 is undefinable");
        }
        if (right == 0) {
            return 1;
        }
        if (left == 0 || left == 1) {
            return left;
        }
        if (left == -1) {
            return right % 2 == 1 ? -1 : 1;
        }
        CheckedMultiply mult = new CheckedMultiply(new Const(1), new Const(1));
        for (int i = 0; i < right; ++i) {
            mult = new CheckedMultiply(new Const(mult.evaluate(1)), new Const(left));
        }
        return mult.evaluate(1);
    }

    @Override
    public BigDecimal eval(BigDecimal left, BigDecimal right) {
        return null;
    }

    @Override
    public Type getType() {
        return Type.POW;
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
        return true;
    }
}
