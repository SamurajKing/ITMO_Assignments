package hw11_12_13_expression;


/**
 * Three-argument arithmetic expression over integers.
 *
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
@FunctionalInterface
@SuppressWarnings("ClassReferencesSubclass")
public interface TripleExpression extends ToMiniString {
    int evaluate(int x, int y, int z);

    private static Const c(final Integer c) {
        return new Const(c);
    }

}
