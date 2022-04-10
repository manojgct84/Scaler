package dc.advance.DynamicPrograming.class1;

import java.util.Arrays;

public class LetsParty {

    public static void main(String[] args) {
        System.out.println(letsParty(5));
    }

    static int[] dp;
    static int mod = 10003;

    public static int letsParty(int A) {
        if (A == 0 || A == 1) {
            return 1;
        }
        dp = new int[A + 1];
        dp[1] = 1;
        dp[2] = 2;
        Arrays.fill(dp, 2, A + 1, -1);
        return getLetsParty(A);
    }

    private static int getLetsParty(int a) {
        if (dp[a] == 0) {
            return 1;
        }

        if (dp[a] == 1) {
            return 1;
        }

        if (dp[a] == 2) {
            return 2;
        }

        if (dp[a] != -1) {
            return dp[a];
        }

        dp[a] = (getLetsParty(a - 1) % mod + (getLetsParty(a - 2) * (a - 1) % mod));
        return dp[a] % mod;
    }
}
