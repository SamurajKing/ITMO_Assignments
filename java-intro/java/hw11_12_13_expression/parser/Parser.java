package hw11_12_13_expression.parser;

import hw11_12_13_expression.TripleExpression;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
@FunctionalInterface
public interface Parser {
    TripleExpression parse(String expression);
}
