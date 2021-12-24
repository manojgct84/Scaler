package dc.advance.combinatorics.assignment;

import java.util.Arrays;

public class ComputenCrModM {
    public static void main(String[] args) {
        System.out.println(getSolve(41, 27, 143));
    }

    private static int nCr(int n, int r, int mod) {
        int res = 1;
        for (int i = 1; i <= r; i++) {
            res *= (n - r + i);
            res /= i;
        }
        return (res % mod);
    }


    public static int getSolve(int A, int B, int C) {
        long[][] nCr = new long[A + 1][B + 1];
        for (int n = 0; n <= A; n++) {
            for (int r = 0; r <= B; r++) {
                if (n == 0 || r == 0 || n == r) {
                    nCr[n][r] = 1;
                } else {
                    nCr[n][r] = (nCr[n - 1][r - 1] + nCr[n - 1][r]) % C;
                }
            }
        }
        System.out.print(Arrays.deepToString(nCr));
        return (int) (nCr[A][B] % C);
    }
}
