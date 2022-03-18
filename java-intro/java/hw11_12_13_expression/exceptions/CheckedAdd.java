package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.Add;
import hw11_12_13_expression.Child;

public class CheckedAdd extends Add {

    public CheckedAdd(Child left, Child right) {
        super(left, right);
    }

    @Override
    public int eval(int left, int right) {
        if ((right >= 0 && left > Integer.MAX_VALUE - right)
                || (right <= 0 && left < Integer.MIN_VALUE - right)) {
            throw new OverflowException();
        }
        return left + right;
    }
}
