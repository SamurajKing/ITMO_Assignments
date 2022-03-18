package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.Child;
import hw11_12_13_expression.Divide;

public class CheckedDivide extends Divide {
    public CheckedDivide(Child left, Child right) {
        super(left, right);
    }
    @Override
    public int eval(int left, int right) {
        if (left == Integer.MIN_VALUE && right == -1) {
            throw new OverflowException();
        }
        if (right == 0) {
            throw new DBZException();
        }
        return left / right;
    }
}
