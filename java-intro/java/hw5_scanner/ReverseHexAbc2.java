package hw5_scanner;

import hw5_scanner.GlobalValidator;

import java.io.*;
import java.util.*;
public class ReverseHexAbc2 {
    public static String getFormat(String s) {
        StringBuilder normal;
        if (s.startsWith("0x")) {
            normal = new StringBuilder(String.valueOf(Integer.parseUnsignedInt(s.substring(2), 16)));
        } else {
            normal = new StringBuilder(s);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < normal.length(); ++i) {
            char c = normal.charAt(i);
            if (c >= 'a' || c == '-')
                ans.append(c);
            else
                ans.append((char)(c - '0' + 'a'));
        }
        return ans.toString();
    }
    public static void main(String[] args) throws IOException {
        FastScanner2 scanner = null;
        String current;
        ArrayList<String[]> list = new ArrayList<>();
        int[] sz = new int[1];
        try {
            scanner = new FastScanner2();
            int i = 0;
            int j = 0;
            while ((current = scanner.nextLine()) != null) {
                current = current.toLowerCase();
                //System.err.println(current);
                FastScanner2 line = null;
                String[] formattedRow = new String[1];
                try {
                    line = new FastScanner2(current);
                    String cur;
                    while ((cur = line.next(new GlobalValidator())) != null) {
                        if (j >= formattedRow.length) {
                            formattedRow = Arrays.copyOf(formattedRow, formattedRow.length * 2);
                        }
                        formattedRow[j++] = getFormat(cur);
                    }
                } catch (IOException e) {
                    System.out.println("Some I/O exception " + e.getMessage());
                } finally {
                    if (line != null)
                        line.close();
                }
                if (i >= sz.length) {
                    sz = Arrays.copyOf(sz, sz.length * 2);
                }
                sz[i] = j;
                j = 0;
                i++;
                list.add(formattedRow);
            }
            for (int line =  i - 1; line >= 0; --line) {
                for (int jj = sz[line] - 1; jj >= 0; --jj) {
                    System.out.print(list.get(line)[jj] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Some I/O exception " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
