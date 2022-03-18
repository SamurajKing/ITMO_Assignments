package hw11_12_13_expression;

import java.math.BigDecimal;

public abstract class UnaryOperation implements Child {
    protected final Child child;
    protected String symbol;
    protected int hash = Integer.MIN_VALUE;

    public UnaryOperation(Child child) {
        this.child = child;
    }
    public UnaryOperation(Child child, String symbol) {
        this.child = child;
        this.symbol = symbol;
    }

    @Override
    public int hashCode(){
        if (hash == Integer.MIN_VALUE) {
            hash = child.hashCode() * 239 + getClass().hashCode();
        }
        return hash;
    }

    public abstract int eval(int x);
    public abstract BigDecimal eval(BigDecimal x);


    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal y, BigDecimal z) {
        return eval(child.evaluate(x, y, z));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return eval(child.evaluate(x, y, z));
    }

    @Override
    public BigDecimal evaluate(BigDecimal x) {
        return eval(child.evaluate(x));
    }

    @Override
    public int evaluate(int x) {
        return eval(child.evaluate(x));
    }

    @Override
    public String toString() {
        return this.symbol + "(" + child.toString() + ")";
    }

    @Override
    public String toMiniString() {
        if (this.getPriority() > child.getPriority()) {
            return this.symbol + "(" + child.toMiniString() + ")";
        } else {
            return this.symbol + " " + child.toMiniString();
        }
    }

}
