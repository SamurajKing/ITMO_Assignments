package hw11_12_13_expression;

import java.math.BigDecimal;
/**
 * One-argument arithmetic expression over longs.
 *
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
@FunctionalInterface
@SuppressWarnings("ClassReferencesSubclass")
public interface BigDecimalExpression extends ToMiniString {
    BigDecimal evaluate(BigDecimal x);

}
