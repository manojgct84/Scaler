package dc.advance.mod.assignment;

import java.util.Arrays;

public class PairSumDivisibleByM {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{2, 7, 5, 10, 8, 4, 6, 11}, 5));
    }

    // 1 , 3, 1
    // 2 , 4

    public static int getSolve(int[] A, int B) {
        long[] freq = new long[B];
        int mod = 1000000007;
        for (int j : A) {
            freq[j % B]++;
        }

        System.out.println(Arrays.toString(freq));

        long res = (freq[0] * (freq[0] - 1)) / 2;

        if ((B & 1) == 0) { // even
            res += (freq[B / 2] * (freq[B / 2] - 1)) / 2;
        }

        for (int i = 1; i <= (B - 1) / 2; i++) { // odd
            res += (freq[i] * freq[B - i]);
        }
        return (int) res % mod;
    }

}
