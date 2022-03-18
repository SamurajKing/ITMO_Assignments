package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.Child;
import hw11_12_13_expression.Subtract;

public class CheckedSubtract extends Subtract {
    public CheckedSubtract(Child left, Child right) {
        super(left, right);
    }

    @Override
    public int eval(int left, int right) {
        if ((right >= 0 && left < Integer.MIN_VALUE + right)
        || (right <= 0 && left > Integer.MAX_VALUE + right)) {
            throw new OverflowException();
        }
        return left - right;
    }
}
