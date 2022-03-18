package hw3_reverse;


import hw5_scanner.FastScanner2;

import java.io.*;
public class Reverse {
    private static final int MAX_LEN = 1_000_000;
    public static void main(String[] args) throws IOException {
        String[] rows = new String[MAX_LEN];
        FastScanner2 scanner = new FastScanner2();
        int currentRow = 0;
        //char c = 0x00E0 + 6;
        //System.err.println("! " + (c == '\n') + " " + c);
        try {
            String current;
            while ((current = scanner.nextLine()) != null) {
                rows[currentRow++] = current;
                //System.err.println("! " + current);
            }

            for (int i = currentRow - 1; i >= 0; --i) {
                String[] currentNums = rows[i].split(" +");
                for (int j = currentNums.length - 1; j >= 0; --j) {
                    System.out.print(currentNums[j] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
