package hw6_wordstatpp;

import hw5_scanner.FastScanner2;
import hw5_scanner.WordValidator;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.nio.charset.*;
public class WsppSortedSecondG {
    public static boolean wordSymbol(char c) {
        return Character.isLetter(c) 
        || Character.getType(c) == Character.DASH_PUNCTUATION 
        || c == '\'';
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        String inFile = args[0];
        String outFile = args[1];        
        FastScanner2 in = null;
        Map<String, PairIntList> wordsCount = new TreeMap<>(); //String, ((realIdx, lineNumber), ...)
        try {
            in = new FastScanner2(new File(inFile), StandardCharsets.UTF_8);
            int i = 0;
            WordValidator wordValidator = new WordValidator();
            int line = in.getLineNumber();
            System.err.println("-----------------------------");
            while (in.hasNext(wordValidator)) {
                String word = in.next(wordValidator).toLowerCase();
                if (in.getLineNumber() - 1 == line) {
                    line++;
                    System.err.println();
                }
                System.err.print(word + " ");
                if (wordsCount.containsKey(word)) {
                    wordsCount.get(word).add(new Pair1(i + 1, in.getLineNumber()));
                } else {
                    PairIntList current = new PairIntList();
                    current.add(new Pair1(i + 1, in.getLineNumber()));
                    wordsCount.put(word, current);
                }
                i++;
            }
            System.err.println("\n------------------------------------");
        } catch (IOException e) {
            System.out.println("Sorry, some IO exception :( " + e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Sorry, some IO exception :( " + e.getMessage());
                }
            }
        }
        
        try (BufferedWriter out = 
            new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(outFile), "utf8")
                    );  ) {
            for (Map.Entry<String, PairIntList> entry : wordsCount.entrySet()) {
                String key = entry.getKey();
                PairIntList value = entry.getValue();
                out.write(key + " " + value.size());
                int j = 0;
                int curLineNumber = value.get(0).getSecond();
                for (int jj = 0; jj < value.size(); ++jj) {
                    if (value.get(jj).getSecond() != curLineNumber) {
                        curLineNumber = value.get(jj).getSecond();
                        j = 0;
                    }
                    if ((j + 1) % 2 == 0) {
                        out.write(" " + value.get(jj).getFirst());
                    }
                    j++;
                }
                out.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, file not found :( " + e.getMessage());  
        } catch (IOException e) {
            System.out.println("Sorry, some IO exception :( " + e.getMessage());
        }
    }
}
