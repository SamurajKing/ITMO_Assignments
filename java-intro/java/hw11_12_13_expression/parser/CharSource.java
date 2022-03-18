package hw11_12_13_expression.parser;

public interface CharSource {
    char next();
    boolean hasNext();
    char safeNext();
    IllegalArgumentException error(String message);
}
