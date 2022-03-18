package hw2_sum;

import java.lang.String;
import java.math.BigInteger;
public class SumBigIntegerHex {
    
    public static BigInteger calculateSum(String current) {
        BigInteger currentSum = BigInteger.ZERO;
        int i = 0;
        int j = 0;
        
        while (i < current.length()) {
            if (Character.isWhitespace(current.charAt(i))) {
                i++;
            } else {
                j = i;
                while (j < current.length() && !Character.isWhitespace(current.charAt(j))) {
                    j++;
                } 
                String currentNumber = current.substring(i, j).toLowerCase();
                
                if (currentNumber.startsWith("0x")) {
                    currentSum = currentSum.add(new BigInteger(currentNumber.substring(2), 16));
                } else {
                    currentSum = currentSum.add(new BigInteger(currentNumber));
                }
                i = j;     
            }
        }
                
        return currentSum;
    }
    
    public static void main(String[] args) {
        BigInteger finalSum = BigInteger.ZERO;
        for (int i = 0; i < args.length; ++i) {
            finalSum = finalSum.add(calculateSum(args[i]));
        }
        
        System.out.println(finalSum.toString());
    }
}











//" - 5 + 5 - - 5 + --5" + "5" + " - " + " 5"
