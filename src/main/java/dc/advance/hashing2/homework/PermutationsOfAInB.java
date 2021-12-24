package dc.advance.hashing2.homework;

import java.util.Arrays;

public class PermutationsOfAInB {

    public static void main(String[] args) {
        System.out.println(getSolve("bbca", "abbcbaz"));
        System.out.println(getSolve("abc", "abcbacabc"));
        System.out.println(getSolve("aca", "acaa"));
    }

    public static int getSolve(String A, String B) {
        int[] a = new int[26];


        for (int i = 0; i < 26; i++) {
            a[A.charAt(i) - 'a']++;
            // b[A.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(a));
        int r = 0;
        int l = 0;
        int count = 26;
        int res = 0;
        int[] b = new int[26];
        while (r < B.length()) {
            b[B.charAt(r) - 'a']++;
            if ((r - l + 1) == A.length()) {
                for (int i = 0; i < 26; i++) {
                    if (a[i] == b[i]) {
                        continue;
                    } else {
                        count--;
                    }
                }
                if (count == 26) {
                    res++;
                } else {
                    count = 26;
                }
                b[B.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return res;
    }
}
