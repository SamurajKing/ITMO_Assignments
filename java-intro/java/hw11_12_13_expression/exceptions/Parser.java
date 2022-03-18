package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.TripleExpression;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
@FunctionalInterface
public interface Parser {
    TripleExpression parse(String expression) throws /* Change me */ Exception;
}
