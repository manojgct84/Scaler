package dc.advance.DynamicPrograming.class1;

import java.util.Arrays;

public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println(prefectSquare(6));
    }

    static int[] dp;

    public static int prefectSquare(int n) {
        dp = new int[n + 1];
        dp[0] = -1;
        Arrays.fill(dp, 1, n + 1, -1);
        return prefectSq(n);

    }

    private static int prefectSq(int n) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int temp = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            temp = Math.min(temp, prefectSq(n - i * i));
        }
        dp[n] = 1 + temp;
        return dp[n];
    }

}
