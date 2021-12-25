package dc.advance.resursion.reversion.recursion1.homework;

import java.util.Scanner;

public class PrintReverseString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(reverseString(str, 0, str.length()));
    }

    public static String reverseString(String s, int index, int len) {
        if (len == index) {
            return s;
        }
        return reverseString(s.substring(1, s.length()), index + 1, len) + s.charAt(0);
    }
}
