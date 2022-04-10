package dc.advance.DynamicPrograming.class2;

import java.util.Arrays;

public class DungeonPrincess {

    public static void main(String[] args) {
        System.out.println(
                calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(calculateMinimumHP(new int[][]{{1, -1, 0}, {-1, 1, -1}, {1, 0, -1}}));
    }

    static int[][] dp;
    static int[][] energy;

    public static int calculateMinimumHP(int[][] A) {
        dp = new int[A.length][A[0].length];
        energy = new int[A.length][A[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        calculateMinimumHPRecursion(A, 0, 0);
        System.out.println(dp[0][0]);
        calculateMinimumHPIterative(A);
        return energy[0][0];
    }

    private static int calculateMinimumHPRecursion(int[][] a, int r, int c) {

        if (r == a.length - 1 && c == a[0].length - 1) {
            dp[r][c] = Math.max(1 - a[r][c], 1);
            return dp[r][c];
        } else if (r == a.length - 1) {
            dp[r][c] = Math.max(calculateMinimumHPRecursion(a, r, c + 1) - a[r][c], 1);
            return dp[r][c];
        } else if (c == a[0].length - 1) {
            dp[r][c] = Math.max(calculateMinimumHPRecursion(a, r + 1, c) - a[r][c], 1);
            return dp[r][c];
        } else if (dp[r][c] != Integer.MAX_VALUE) {
            return dp[r][c];
        } else {
            dp[r][c] = Math.max(1, (Math.min(
                    calculateMinimumHPRecursion(a, r + 1, c),
                    calculateMinimumHPRecursion(a, r, c + 1)) - a[r][c]));
            return dp[r][c];
        }
    }

    private static void calculateMinimumHPIterative(int[][] a) {

        for (int r = a.length - 1; r >= 0; r--) {
            for (int c = a[0].length - 1; c >= 0; c--) {
                if (r == a.length - 1 && c == a[0].length - 1) {
                    energy[r][c] = Math.max(1 - a[r][c], 1);
                } else if (r == a.length - 1) {
                    energy[r][c] = Math.max(energy[r][c + 1] - a[r][c], 1);
                } else if (c == a[0].length - 1) {
                    energy[r][c] = Math.max(energy[r + 1][c] - a[r][c], 1);
                } else {
                    energy[r][c] = Math.max(1, (Math.min(energy[r + 1][c], energy[r][c + 1]) - a[r][c]));
                }
            }
        }
    }
}
