package dc.advance.DynamicPrograming.class1;

import java.util.Arrays;

public class Stairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    static int[] dp;

    public static int climbStairs(int A) {
        dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 1;
        Arrays.fill(dp, 2, A + 1, -1);
        return getClimbStairs(A);
    }

    private static int getClimbStairs(int a) {
        if (a == 0) {
            return dp[0];
        }

        if (a == 1) {
            return dp[1];
        }

        if (dp[a] != -1) {
            return dp[a];
        }

        dp[a] = getClimbStairs(a - 1) + getClimbStairs(a - 2);
        return dp[a];
    }
}
