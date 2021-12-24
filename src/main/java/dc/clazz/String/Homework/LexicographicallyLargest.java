package dc.clazz.String.Homework;

import java.util.Arrays;

public class LexicographicallyLargest {

    public static void main(String[] args) {
        String str = "zyabcddee_zybdc";
        System.out.println(getsolution(str));
    }

    public static String getsolution(String A) {
        String[] array = A.split("_");
        char[] s = array[0].toCharArray();
        char[] t = array[1].toCharArray();
        Arrays.sort(t);
        int i = 0;
        int j = t.length - 1;
        while (i < s.length && j >= 0) {
            if (s[i] < t[j]) {
                s[i] = t[j];
                j--;
            }
            i++;

        } //TC O(N)
        return String.valueOf(s);
    }
}
