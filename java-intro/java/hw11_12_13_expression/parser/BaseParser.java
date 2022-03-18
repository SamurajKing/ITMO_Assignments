package hw11_12_13_expression.parser;

public class BaseParser {
    protected static final char END = 0;
    protected final CharSource source;
    private char ch;

    public BaseParser(CharSource source) {
        this.source = source;
        take();
    }

    protected boolean test(final char expected) {
        return ch == expected;
    }

    protected char take() {
        final char current = ch;
        ch = source.hasNext() ? source.next() : END;
        return current;
    }

    protected boolean take(final char expected) {
        if (test(expected)) {
            take();
            return true;
        }
        return false;
    }

    protected boolean hasNext() {
        return ch != END;
    }

    protected boolean predictNext(char expected) {
        if (hasNext()) {
            return source.safeNext() == expected;
        }
        return false;
    }

    protected char getCurrent() {
        return ch;
    }

    protected void expect(final char expected) {
        if (!take(expected)) {
            throw source.error(String.format(
                    "Expected '%s', found '%s'",
                    expected, ch
            ));
        }
    }

    protected boolean between(char left, char right) {
        return left <= ch && ch <= right;
    }

    protected void expect(final String expected) {
        for (final char c : expected.toCharArray()) {
            expect(c);
        }
    }
}
