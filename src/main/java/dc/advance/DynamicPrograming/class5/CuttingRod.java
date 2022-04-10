package dc.advance.DynamicPrograming.class5;

import java.util.Arrays;

public class CuttingRod {
    public static void main(String[] args) {

        System.out.println(cuttingRod(new int[]{3, 4, 1, 6, 2}));
        System.out.println(cuttingRod(new int[]{1, 5, 2, 5, 6}));
    }

    static int[][] max;

    public static int cuttingRod(int[] A) {
        int[] lenOfRod = new int[A.length];
        max = new int[A.length + 1][A.length + 1];
        for (int i = 0; i <= A.length; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < A.length; i++) {
            lenOfRod[i] = i + 1;
        }

        return cuttingRodRecursion(A, A.length, A.length, lenOfRod);
    }

    private static int cuttingRodRecursion(int[] price, int maxLengthOfRod, int N, int[] lenOfRod) {

        if (N == 0 || maxLengthOfRod <= 0) {
            return 0;
        }
        if (max[N][maxLengthOfRod] != Integer.MIN_VALUE) {
            return max[N][maxLengthOfRod];
        }

        if (lenOfRod[N - 1] <= maxLengthOfRod) {
            int y = cuttingRodRecursion(price, maxLengthOfRod, N - 1, lenOfRod);
            int x = price[N - 1] + cuttingRodRecursion(price, maxLengthOfRod - lenOfRod[N - 1], N, lenOfRod);
            max[N][maxLengthOfRod] = Math.max(x, y);
        } else {
            max[N][maxLengthOfRod] = cuttingRodRecursion(price, maxLengthOfRod, N - 1, lenOfRod);
        }
        return max[N][maxLengthOfRod];
    }
}
