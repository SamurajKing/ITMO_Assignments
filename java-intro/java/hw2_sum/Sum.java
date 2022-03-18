package hw2_sum;

import java.lang.String;
public class Sum {
    public static int calculateSum(String current) {
        int currentSum = 0;
        int currentCoef = 1;
        int i = 0;
        int j = 0;
        while (i < current.length()) {
            if (Character.isWhitespace(current.charAt(i))) {
                i++;
            } else if (Character.isDigit(current.charAt(i))) {
                j = i;
                while (j < current.length() && Character.isDigit(current.charAt(j))) {
                    j++;
                } 
                currentSum += currentCoef * Integer.parseInt(current.substring(i, j));
                i = j;     
                currentCoef = 1;
            } else {
                if (current.charAt(i) == '-') {
                    currentCoef *= -1;
                }
                i++;
            }
        }
        
        return currentSum;
    }
    
    public static void main(String[] args) {
        String concatedString = "";
        for (int i = 0; i < args.length; ++i) {
            concatedString = concatedString.concat(new String(args[i] + " "));
        }

        System.out.println(calculateSum(concatedString.toString()));
    }
}

//" - 5 + 5 - - 5 + --5" + "5" + " - " + " 5"
