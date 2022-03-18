package hw3_reverse;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class ReverseSum2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<int[]> numbers = new ArrayList<>();  
        int colSize = 0;
        for (int i = 0; in.hasNextLine(); ++i) {
            Scanner currentLine = new Scanner(in.nextLine());
            int p = 0;
            int mas[] = new int[1];
            for (int j = 0; currentLine.hasNextInt(); ++j) {
                int number = currentLine.nextInt();
                if (j == mas.length) {
                    mas = Arrays.copyOf(mas, mas.length * 2);
                }
                ++p;
                mas[j] = number;
            }
            for (int j = p; j < mas.length; ++j) {
                mas[j] = -1;
            }
            numbers.add(mas);
            colSize = Math.max(colSize, p);
        } 

        int[] colsum = new int[colSize];
        
        for (int i = 0; i < numbers.size(); ++i) {
            int summary = 0;
            for (int j = 0; j < numbers.get(i).length; ++j) {
                if (numbers.get(i)[j] == -1) {
                    continue;
                }
                colsum[j] += numbers.get(i)[j];
                summary += colsum[j];
                System.out.print(summary + " ");
            }
            System.out.println();
        }                        
    }
}
//1 2 3
//4 5
//6 7 8


//1 2
//3 4 5

//1 2 3
//4 5 6 7 8
//9 9 9 9 9 9 9 9

//1 2
//3 4 5
//2 3 1
