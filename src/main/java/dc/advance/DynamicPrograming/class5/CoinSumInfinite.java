package dc.advance.DynamicPrograming.class5;

import java.util.Arrays;

public class CoinSumInfinite {

    public static void main(String[] args) {

        System.out.println(coinchange2(new int[]{1, 2, 3}, 4));
        System.out.println(coinchange2(new int[]{10}, 10));
    }

    static int[][] coinDp;

    public static int coinchange2(int[] changes, int repuee) {
        coinDp = new int[changes.length + 1][repuee + 1];
        for (int i = 0; i <= changes.length; i++) {
            Arrays.fill(coinDp[i], -1);
        }
        return coinchangeProblem(changes, repuee, changes.length);
    }

    private static int coinchangeProblem(int[] changes, int repuee, int N) {

        if (N == 0 && repuee == 0) {
            coinDp[N][repuee] = 1;
            return 1;
        }

        if (N == 0 && repuee > 0) {
            coinDp[N][repuee] = 0;
            return 0;
        }
        if (N >= 0 && repuee == 0) {
            coinDp[N][repuee] = 1;
            return 1;
        }

        if (coinDp[N][repuee] != -1) {
            return coinDp[N][repuee];
        }

        if (repuee >= changes[N - 1]) {
            coinDp[N][repuee] = coinchangeProblem(changes, repuee - changes[N - 1], N) +
                coinchangeProblem(changes, repuee, N - 1);
        } else {
            coinDp[N][repuee] = coinchangeProblem(changes, repuee, N - 1);
        }
        return coinDp[N][repuee];
    }
}
