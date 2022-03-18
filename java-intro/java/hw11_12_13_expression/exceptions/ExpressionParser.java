package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.*;
import hw11_12_13_expression.parser.BaseParser;
import hw11_12_13_expression.parser.CharSource;
import hw11_12_13_expression.parser.StringCharSource;


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
            throw new IncorrectContinueException("End of expression expected");
        }

        private Child parseZero() {
            Child result = parseFirst();
            skipWhitespace();

            while (hasNext()) {
                if (take('<')) {
                    take('<');
                    result = new CheckedShiftLeft(result, parseFirst());
                } else if (take('>')) {
                    take('>');
                    if (test('>')) {
                        take('>');
                        result = new CheckedArithmeticShiftRight(result, parseFirst());
                    } else {
                        result = new CheckedShiftRight(result, parseFirst());
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
                    result = new CheckedAdd(result, parseSecond());
                } else if (take('-')) {
                    result = new CheckedSubtract(result, parseSecond());
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
                    result = new CheckedMultiply(result, parseThird());
                } else if (take('/')) {
                    result = new CheckedDivide(result, parseThird());
                } else {
                    break;
                }
                skipWhitespace();
            }
            return result;
        }

        private Child parseThird() {
            Child result = parseFourth();

            skipWhitespace();

            while (hasNext()) {
                if (test('*')) {
                    if (predictNext('*')) {
                        take();
                        take();
                        result = new CheckedPow(result, parseFourth());
                    } else {
                        break;
                    }
                } else if (test('/')) {
                    if (predictNext('/')) {
                        take();
                        take();
                        result = new CheckedLog(result, parseFourth());
                    } else {
                        break;
                    }
                } else {
                    break;
                }
                skipWhitespace();
            }
            return result;
        }

        private Child parseFourth() {
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
                    return new CheckedNegate(parseFourth());
                } else if (test('(')) {
                    take();
                    Child ret = parseZero();
                    if(!test(')')) {
                        throw new IncorrectContinueException("Expected ). Found " + this.getCurrent());
                    }
                    take();
                    return ret;
                } else if (take('a')) {
                    if (!take('b')) {
                        throw new IncorrectContinueException("Incorrect continue. Expected b");
                    }
                    if (!take('s')) {
                        throw new IncorrectContinueException("Incorrect continue. Expected s");
                    }
                    if (!(Character.isWhitespace(getCurrent()) || getCurrent() == '(')) {
                        throw new IncorrectContinueException("Incorrect continue. Expected space or (");
                    }
                    return new CheckedAbs(parseFourth());
                } else {
                    throw new IncorrectContinueException("Incorrect end. Expected third priority");
                }
            }
            throw new IncorrectContinueException("Incorrect end. Expected third priority");
        }

        private String getNumber() {
            StringBuilder number = new StringBuilder();
            while (between('0', '9')) {
                number.append(take());
            }
            return number.toString();
        }

        private Child parseNumber(String number) {
            return new CheckedConst(Integer.parseInt(number));
        }

        private Child parseVariable() {
            assert test('x') | test('y') | test('z');
            String var = String.valueOf(take());
            skipWhitespace();
            return new CheckedVariable(var);
        }
    }
}
