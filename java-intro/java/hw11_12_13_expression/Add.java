package hw11_12_13_expression;

import java.math.BigDecimal;

public class Add extends BinaryOperation {
    public Add(Child left, Child right) {
        super(left, right, "+");
    }

    @Override
    public int eval(int left, int right) {
        return left + right;
    }

    @Override
    public BigDecimal eval(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Add) &&
                ((Add) other).left.equals(this.left)
                && ((Add) other).right.equals(this.right);
    }


    @Override
    public Type getType() {
        return Type.ADD;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean isAssociative() {
        return true;
    }

    @Override
    public boolean mustWrap() {
        return false;
    }
}
