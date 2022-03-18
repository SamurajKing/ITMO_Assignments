package hw11_12_13_expression;

import java.math.BigDecimal;

public class Variable implements Child {
    private final String name;
    public Variable(String name) {
        this.name = name;
    }
    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Variable) &&
                ((Variable) other).name.equals(this.name);
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String toMiniString() {
        return name;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        switch (this.name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
        }
        throw new UnsupportedOperationException("variable should be one of {x, y, z}");
    }

    @Override
    public BigDecimal evaluate(BigDecimal x) {
        return x;
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal y, BigDecimal z) {
        switch (this.name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
        }
        throw new UnsupportedOperationException("variable should be one of {x, y, z}");
    }

    @Override
    public Type getType() {
        return Type.VARIABLE;
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
        return false;
    }
}
