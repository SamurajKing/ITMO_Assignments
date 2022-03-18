import hw6_wordstatpp.IntList;

import java.io.*;
import java.util.*;
import java.lang.*;
public class Wspp {
    public static boolean wordSymbol(char c) {
        return Character.isLetter(c) 
        || Character.getType(c) == Character.DASH_PUNCTUATION 
        || c == '\'';
    }
    
    public static void main(String[] args) {
        //завожу массив всех слов
        //завожу массив всех уникальных отсорченных слов => для каждого слова есть индекс
        //делаю сортировку подсчетом
        //вывожу слова в нужном порядке используя массив seen[i]
        String inFile = args[0];
        String outFile = args[1];           
        try (
            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(inFile), 
                    "utf8"
                )
            );
            BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(outFile), 
                    "utf8"
                )
            );
        ) {
            Map<String, IntList> wordsCount = new LinkedHashMap<>();
            int i = 0;
            while (true) {
                int ss = in.read();
                if (ss == -1) {
                    break;
                }
                char sym = (char) ss;
                if (!wordSymbol(sym)) {
                    continue;
                } else {
                    StringBuilder st = new StringBuilder();
                    while (wordSymbol(sym)) {
                        st.append(sym);
                        ss = in.read();
                        if (ss == -1) {
                            break;
                        }
                        sym = (char)ss;
                    }
                    String cur = st.toString().toLowerCase();
                    if (wordsCount.containsKey(cur)) {
                        wordsCount.get(cur).add(i + 1);
                    } else {
                        IntList current = new IntList();
                        current.add(i + 1);
                        wordsCount.put(cur, current);
                    }
                    i++;
                }
            }

            for (Map.Entry<String, IntList> entry : wordsCount.entrySet()) {
                String key = entry.getKey();
                IntList value = entry.getValue();
                out.write(key + " " + value.size());
                for (int j = 0; j < value.size(); ++j) {
                    out.write(" " + value.get(j));
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
