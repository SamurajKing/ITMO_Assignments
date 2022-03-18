package hw11_12_13_expression;


/**
 * One-argument arithmetic expression over integers.
 *
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
@FunctionalInterface
@SuppressWarnings("ClassReferencesSubclass")
public interface Expression extends ToMiniString {
    int evaluate(int x);

    private static Const c(final int c) {
        return new Const(c);
    }

}
