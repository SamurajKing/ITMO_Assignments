package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.BinaryOperation;
import hw11_12_13_expression.Child;
import hw11_12_13_expression.Type;

import java.math.BigDecimal;

public class CheckedLog extends BinaryOperation {
    public CheckedLog(Child left, Child right) {
        super(left, right, "//");
    }

    @Override
    public int eval(int left, int right) {
       if (!(right > 0 && right != 1) || left <= 0) {
           throw new IllegalLogException();
       }
       //max j: right ^ j <= left
       int j = 0;
       int res = 1;
       while (true) {
           if (CheckedMultiply.safeMultiply(res, right) && res * right <= left) {
               res *= right;
               j++;
           } else {
               break;
           }
       }
       return j;
    }

    @Override
    public BigDecimal eval(BigDecimal left, BigDecimal right) {
        return null;
    }

    @Override
    public Type getType() {
        return Type.LOG;
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
