package hw5_scanner;

import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
public class FastScanner2 {
    private final int BUFFER_CAPACITY = 1024;

    /* unicode new line constants */
    private final String SEPARATOR = System.lineSeparator();
    
    private char[] buffer;
    private int currentPosition;
    private final Reader in;
    private boolean isEOF;
    private int bufferSize;
    private int lineNumber;
    
    private void init() {
        buffer = new char[BUFFER_CAPACITY];
        currentPosition = 0;
        isEOF = false;
        bufferSize = 0;
        lineNumber = 0;
    }

    public FastScanner2() throws IOException {
        init();
        in = new InputStreamReader(System.in);
    }

    public FastScanner2(File file, Charset charset) throws FileNotFoundException, IOException {
        init();
        in = new InputStreamReader(new FileInputStream(file), charset);
    }

    public FastScanner2(String text) throws IOException {
        init();
        in = new StringReader(text);
    }

    private void rebufferIfNeed() throws IOException {
        if (currentPosition == bufferSize) {
            bufferSize = in.read(buffer);
            currentPosition = 0;
        }

        if (bufferSize == -1) {
            isEOF = true;
        }
    }

    private boolean hasNextSymbol() throws IOException {
        rebufferIfNeed();
        return !isEOF;
    }

    private char getNextSymbol() throws IOException {
        if (!hasNextSymbol()) {
            throw new NoSuchElementException();
        }
        return buffer[currentPosition];
    }

    public int read() throws IOException {
        if (!hasNextSymbol()) {
            return -1;
        }
        return buffer[currentPosition++];
    }

    public void skip(Validator val) throws IOException {
        if (SEPARATOR.length() == 1) {
            while (hasNextSymbol()
                    && !val.isValidatedSymbol(getNextSymbol())) {
                if (getNextSymbol() == SEPARATOR.charAt(0)) {
                    ++lineNumber;
                }
                currentPosition++;
            }
        } else if (SEPARATOR.length() == 2) {
            while (hasNextSymbol()
                    && !val.isValidatedSymbol(getNextSymbol())) {
                if (getNextSymbol() == SEPARATOR.charAt(0)) {
                    read();
                    if (hasNextSymbol() && !val.isValidatedSymbol(getNextSymbol())
                    && getNextSymbol() == SEPARATOR.charAt(1)) {
                        ++lineNumber;
                    }
                }
                currentPosition++;
            }
        }
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public boolean hasNext(Validator val) throws IOException {
        skip(val);
        return hasNextSymbol();
    }

    
    public boolean hasNextInt() throws IOException { 
        skip(new IntValidator());
        return hasNextSymbol();
    }

    public String next(Validator val) throws IOException {
        StringBuilder nextWord = new StringBuilder();
        char current;

        if (!hasNext(val)) {
            return null;
        }
        
        while (hasNextSymbol() && val.isValidatedSymbol(current = getNextSymbol())) {
            nextWord.append(current);
            currentPosition++;
        }

        return nextWord.toString();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next(new IntValidator()));
    }

    public String getNextLine() throws IOException {   
        char c = ' ';
        StringBuilder line = new StringBuilder();
        while (hasNextSymbol()) {
            c = getNextSymbol();
            if (c == SEPARATOR.charAt(0)) {
                currentPosition++;
                if (SEPARATOR.length() == 2 
                && hasNextSymbol() 
                && getNextSymbol() == SEPARATOR.charAt(1)) {
                    currentPosition++;
                    break;
                } else {
                    break;
                }
            } else {
                line.append(c);
                currentPosition++;
            }
        }
        
        return line.toString();
    }
    
    public String nextLine() throws IOException {
        if (!hasNextSymbol()) {
            return null;
        }
        return getNextLine();
    }

    public void close() throws IOException {
        in.close();
    }
}
