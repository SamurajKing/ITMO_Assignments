package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.Child;
import hw11_12_13_expression.ShiftRight;

public class CheckedShiftRight extends ShiftRight {
    public CheckedShiftRight(Child left, Child right) {
        super(left, right);
    }
    @Override
    public int eval(int left, int right) {
//        if (right < 0) {
//            throw new NegativeShiftException();
//        }
        return left >> right;
    }
}
