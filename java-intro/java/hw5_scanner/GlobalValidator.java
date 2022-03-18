package hw5_scanner;

public class GlobalValidator implements Validator {
    IntValidator intv;
    WordValidator wordv;
    public GlobalValidator() {
        intv = new IntValidator();
        wordv = new WordValidator();
    }
    public boolean isValidatedSymbol(char c) {
        return intv.isValidatedSymbol(c) || wordv.isValidatedSymbol(c);
    }
}
