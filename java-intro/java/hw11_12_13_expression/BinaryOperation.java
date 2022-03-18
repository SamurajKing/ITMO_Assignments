package hw11_12_13_expression;

import java.math.BigDecimal;

public abstract class BinaryOperation implements Child {
    protected final Child left;
    protected final Child right;
    protected int hash = Integer.MIN_VALUE;
    protected String symbol;

    public BinaryOperation(Child left, Child right) {
        this.left = left;
        this.right = right;
    }

    public BinaryOperation(Child left, Child right, String symbol) {
        this.left = left;
        this.right = right;
        this.symbol = symbol;
    }

    public abstract int eval(int left, int right);
    public abstract BigDecimal eval(BigDecimal left, BigDecimal right);

    public int leftEval(int x) {
        return left.evaluate(x);
    }

    public int leftEval(int x, int y, int z) {
        return left.evaluate(x, y, z);
    }

    public int rightEval(int x) {
        return right.evaluate(x);
    }

    public int rightEval(int x, int y, int z) {
        return right.evaluate(x, y, z);
    }

    public BigDecimal leftEval(BigDecimal x, BigDecimal y, BigDecimal z) {
        return left.evaluate(x, y, z);
    }

    public BigDecimal rightEval(BigDecimal x, BigDecimal y, BigDecimal z) {
        return right.evaluate(x, y, z);
    }

    public BigDecimal leftEval(BigDecimal x) {
        return left.evaluate(x);
    }

    public BigDecimal rightEval(BigDecimal x) {
        return right.evaluate(x);
    }

    @Override
    public BigDecimal evaluate(BigDecimal x) { return eval(leftEval(x), rightEval(x)); }

    @Override
    public int evaluate(int x) {
        return eval(leftEval(x), rightEval(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return eval(leftEval(x,y, z), rightEval(x,y,z));
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal y, BigDecimal z) {
        return eval(leftEval(x, y, z), rightEval(x, y, z));
    }

    @Override
    public int hashCode(){
        if (hash == Integer.MIN_VALUE) {
            hash = left.hashCode() * 239 * 239 + right.hashCode() * 239 + getClass().hashCode();
        }
        return hash;
    }

    @Override
    public String toMiniString() {
        String leftPart, rightPart;
        if (this.getPriority() > left.getPriority()) {
            leftPart = "(" + left.toMiniString() + ")";
        } else {
            leftPart = left.toMiniString();
        }

        if (this.getPriority() > right.getPriority()) {
            rightPart = "(" + right.toMiniString() + ")";
        } else {
            if (right.getPriority() > this.getPriority()) {
                rightPart = right.toMiniString();
            } else {
                if (right.mustWrap()) {
                    rightPart = "(" + right.toMiniString() + ")";
                } else {
                    if (this.isAssociative()) {
                        rightPart = right.toMiniString();
                    } else {
                        rightPart = "(" + right.toMiniString() + ")";
                    }
                }
            }
        }
        return leftPart + " " + this.symbol + " " + rightPart;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + symbol + " " + right.toString() + ")";
    }
}
