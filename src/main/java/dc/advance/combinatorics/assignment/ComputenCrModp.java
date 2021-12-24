package dc.advance.combinatorics.assignment;

import java.util.Arrays;

public class ComputenCrModp {

    public static void main(String[] args) {
        System.out.println(getSolve(6, 2, 13));
    }

    public static int getSolve(int A, int B, int C) {
        int[] f = fact(A, C);
        long res = f[A];
        long k = ((long) fermat(f[A - B], C) * fermat(f[B], C)) % C;
        return (int) ((res * k) % C);
    }

    private static int fermat(int A, int b) {
        long result = 1;
        long p = b - 2;
        long a = A;
        while (p > 0) {
            if (p % 2 == 1) {
                result = ((result * a) % b);
                a = (a * a) % b;
                p = (p - 1) / 2;
            } else {
                a = (a * a) % b;
                p >>= 1;
            }
        }
        return (int) result;
    }

    private static int[] fact(int n, int C) {
        int[] fact = new int[n + 1];
        if (n > -1 && n < 2) {
            return new int[]{1, 1};
        }
        long f = 1;
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            f = (f * i) % C;
            fact[i] = (int) f;
        }
        System.out.print(Arrays.toString(fact));
        return fact;
    }
}