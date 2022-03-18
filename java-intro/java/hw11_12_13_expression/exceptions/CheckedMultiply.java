package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.Child;
import hw11_12_13_expression.Multiply;

public class CheckedMultiply extends Multiply {
    public CheckedMultiply(Child left, Child right) {
        super(left, right);
    }
    public static boolean safeMultiply(int left, int right) {
        if ((left > 0 && right > 0 && left > Integer.MAX_VALUE / right)
                || (left > 0 && right < 0 && right < Integer.MIN_VALUE / left)
                || (left < 0 && right > 0 && left < Integer.MIN_VALUE / right)
        ) {
            return false;
        }
        if (left < 0 && right < 0) {
            return left != Integer.MIN_VALUE && right != Integer.MIN_VALUE && -left <= Integer.MAX_VALUE / (-right);
        }
        return true;
    }

    @Override
    public int eval(int left, int right) {
        if (!safeMultiply(left, right)) {
            throw new OverflowException();
        }
        return left * right;
    }

}
