package dc;

import java.util.Arrays;

public class KMPAlgorithm {

    //aabbaaabbaaaabbcd
    //prefix: aabaaba
    //0,1,0,1,2,3,4
    public static void main(String args[]) {
        //  kmp("", "aabaabaca");
           lps("", "oqycntornscygodzdctxnhoc");
        lps("llpbugcswlidtcahvvyctgyxoqe");
    }

    private static void kmp(String str, String prefix) {
        int[] lps = new int[prefix.length()];
        char[] w = prefix.toCharArray();
        int m = w.length;
        int i = 1;
        int j = 0;
        lps[0] = 0;
        while (i < m) {
            if (w[i] == w[j]) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(lps));
    }

    private static void lps(String str, String prefix) {
        String reverse = new StringBuffer(prefix).reverse().toString();
        String concat = prefix + "$" + reverse;
        int j = 0;
        int i = 1;
        char[] w = concat.toCharArray();
        int[] lps = new int[w.length];
        while (i < w.length) {
            if (w[i] == w[j]) {
                j++;
                lps[i] = j;
                i++;
            } else if (j == 0) {
                lps[i] = 0;
                i++;
            } else {
                j = lps[j - 1];
            }
        }
        System.out.println(Arrays.toString(lps));
        System.out.println(prefix.length() - lps[lps.length - 1]);
    }

    private static void lps(String prefix) {
        String reverse = new StringBuffer(prefix).reverse().toString();
        String concat = prefix + "$" + reverse;
        int n = concat.length();
        char[] w = concat.toCharArray();
        int[] lps = new int[n];
        lps[0] = 0;
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && w[i] != w[j]) {
                j = lps[j - 1];
            }
            if (w[i] == w[j]) {
                j++;
            }
            lps[i] = j;
        }
        System.out.println(prefix.length() - lps[lps.length - 1]);
    }
}
