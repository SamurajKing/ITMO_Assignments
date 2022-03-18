package hw11_12_13_expression.parser;

import hw11_12_13_expression.*;


public class ExpressionParser implements Parser {
    @Override
    public Child parse(String expression) {
        return new Expr(new StringCharSource(expression)).parse();
    }

    private static class Expr extends BaseParser {

        public Expr(CharSource source) {
            super(source);
        }

        private void skipWhitespace() {
            while (Character.isWhitespace(getCurrent())) {
                // skip
                take();
            }
        }

        private Child parse() {
            final Child result = parseZero();
            if (test(END)) {
                return result;
            }
            throw this.source.error("End of expression expected");
        }

        private Child parseZero() {
            Child result = parseFirst();
            skipWhitespace();

            while (hasNext()) {
                if (take('<')) {
                    take('<');
                    result = new ShiftLeft(result, parseFirst());
                } else if (take('>')) {
                    take('>');
                    if (test('>')) {
                        take('>');
                        result = new ArithmeticShiftRight(result, parseFirst());
                    } else {
                        result = new ShiftRight(result, parseFirst());
                    }
                } else {
                    break;
                }
            }
            return result;
        }

        private Child parseFirst() {
            Child result = parseSecond();

            skipWhitespace();

            while (hasNext()) {
                if (take('+')) {
                    result = new Add(result, parseSecond());
                } else if (take('-')) {
                    result = new Subtract(result, parseSecond());
                } else {
                    break;
                }
                skipWhitespace();
            }
            return result;
        }

        private Child parseSecond() {
            Child result = parseThird();

            skipWhitespace();

            while (hasNext()) {
                if (take('*')) {
                    result = new Multiply(result, parseThird());
                } else if (take('/')) {
                    result = new Divide(result, parseThird());
                } else {
                    break;
                }
                skipWhitespace();
            }
            return result;
        }

        private Child parseThird() {
            skipWhitespace();

            while (hasNext()) {
                if (test('x') || test('y') || test('z')) {
                    return parseVariable();
                } else if (between('0', '9')) {
                    return parseNumber(getNumber());
                } else if (test('-')) {
                    take();
                    if (between('0', '9')) {
                        String number = "-" + getNumber();
                        return parseNumber(number);
                    }
                    return new UnaryMinus(parseThird());
                } else if (test('(')) {
                    take();
                    Child ret = parseZero();
                    test(')');
                    take();
                    return ret;
                } else if (take('l')) {
                    take('0');
                    return new HighBits(parseThird());
                } else if (take('t')) {
                    take('0');
                    return new LowerBits(parseThird());
                }
            }
            throw this.source.error("Incorrect end. Expected third priority");
        }

        private String getNumber() {
            StringBuilder number = new StringBuilder();
            while (between('0', '9')) {
                number.append(take());
            }
            return number.toString();
        }

        private Child parseNumber(String number) {
            return new Const(Integer.parseInt(number));
        }

        private Child parseVariable() {
            assert test('x') | test('y') | test('z');
            String var = String.valueOf(take());
            skipWhitespace();
            return new Variable(var);
        }
    }
}
