package hw10_mnk;

public class Utilites {
    public static boolean isNumber(String s) {
        boolean yes = true;
        for (int i = 0; i < s.length(); ++i) {
            char u = s.charAt(i);
            yes &= ('0' <= u && u <= '9');
        }
        return yes;
    }
}
