package hw5_scanner;

public class IntValidator implements Validator {
    public boolean isValidatedSymbol(char c) {
        return c >= '0' && c <= '9' || c == '-';
    }
}
