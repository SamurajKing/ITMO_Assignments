package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.Child;
import hw11_12_13_expression.UnaryMinus;

public class CheckedNegate extends UnaryMinus {
    public CheckedNegate(Child child) {
        super(child);
    }
    @Override
    public int eval(int x) {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return -x;
    }

    @Override
    public int getPriority() {
        return 4;
    }
}
