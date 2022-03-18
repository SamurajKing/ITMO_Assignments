package hw11_12_13_expression;


import java.math.BigInteger;

/**
 * One-argument arithmetic expression over longs.
 *
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
@FunctionalInterface
@SuppressWarnings("ClassReferencesSubclass")
public interface BigIntegerExpression extends ToMiniString {
    BigInteger evaluate(BigInteger x);

}
