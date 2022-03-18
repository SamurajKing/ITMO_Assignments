package hw11_12_13_expression;

import java.math.BigDecimal;

public class Const implements Child {
    private int c;
    private BigDecimal bigC;

    public Const(int c) {
        this.c = c;
        this.bigC = null;
    }

    public Const(BigDecimal bigC) {
        this.bigC = bigC;
        this.c = -1;
    }

    @Override
    public int evaluate(int x) {
        return c;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Const) &&
                ((((Const) other).bigC == null
                && this.bigC == null
                && this.c == ((Const) other).c)
                        || (this.bigC != null && ((Const) other).bigC.equals(this.bigC)));
    }

    @Override
    public int hashCode(){
        if (this.bigC == null) {
            return c;
        } else {
            return bigC.hashCode();
        }
    }

    @Override
    public String toString() {
        if (this.bigC == null) {
            return String.valueOf(c);
        } else {
            return bigC.toString();
        }
    }

    @Override
    public String toMiniString() {
       return this.toString();
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return c;
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal y, BigDecimal z) {
        return bigC;
    }

    @Override
    public Type getType() {
        return Type.CONST;
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean isAssociative() {
        throw new UnsupportedOperationException("This is const!");
    }

    @Override
    public boolean mustWrap() {
        return false;
    }

    @Override
    public BigDecimal evaluate(BigDecimal x) {
        return bigC;
    }
}
