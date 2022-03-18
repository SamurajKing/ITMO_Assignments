package hw11_12_13_expression;

import java.math.BigDecimal;

public interface Child extends Expression, TripleExpression, BigDecimalExpression {
    BigDecimal evaluate(BigDecimal x, BigDecimal y, BigDecimal z);
    Type getType();
    int getPriority();
    boolean isAssociative();
    boolean mustWrap();
}
