package dc.advance.DynamicPrograming.class2;

public class MinSumPathMatrix {
    //min cost
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 2}, {4, 3, 1}, {5, 6, 1}}));
        System.out.println(minPathSum(new int[][]{{1, -3, 2}, {2, 5, 10}, {5, -5, 1}}));
    }

    static int[][] dp;

    public static int minPathSum(int[][] A) {
        dp = new int[A.length][A[0].length];
        if (A.length == 1 && A[0].length == 1) {
            return Math.max(A[0][0], 0);
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        minPathSumIterDp(A, A.length, A[0].length);
        minPathSumdp(A, A.length - 1, A[0].length - 1);
        return dp[A.length - 1][A[0].length - 1];
    }

    private static int minPathSumdp(int[][] a, int n, int m) {
        if (n == 0 && m == 0) {
            dp[0][0] = a[0][0];
            return dp[n][m];
        } else if (n == 0) {
            dp[n][m] = minPathSumdp(a, n, m - 1) + a[n][m];
            return dp[n][m];
        } else if (m == 0) {
            dp[n][m] = minPathSumdp(a, n - 1, m) + a[n][m];
            return dp[n][m];
        } else if (dp[n][m] != Integer.MAX_VALUE) {
            return dp[n][m];
        } else {
            dp[n][m] = a[n][m] + Math.min(minPathSumdp(a, n - 1, m), minPathSumdp(a, n, m - 1));
            return dp[n][m];
        }
    }

    private static int minPathSumIterDp(int[][] a, int n, int m) {
        dp[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = a[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = a[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                dp[i][j] = a[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }
}