package hw5_scanner;

public class WordValidator implements Validator {
    public boolean isValidatedSymbol(char c) {
        return Character.isLetter(c)
                        || Character.getType(c) == Character.DASH_PUNCTUATION
                        || c == '\'';
    }
}
