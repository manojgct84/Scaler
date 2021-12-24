package dc.advance.array2;

import java.util.Arrays;

public class SubMatrixSumQueries {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolution(new int[][]{{5, 17, 100, 11},
                {0, 0, 2, 8}}, new int[]{1, 1}, new int[]{1, 4}, new int[]{2, 2}, new int[]{2, 4})));
    }

    public static int[] getSolution(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        long mod = 1000000007;
        long[][] sum = new long[A.length + 1][A[0].length + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= A[0].length; j++) {
                if (i == 0 || j == 0) sum[i][j] = 0;
                else
                    sum[i][j] = A[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        int[] res = new int[B.length];
        //System.out.println(Arrays.deepToString(sum));
        long total;
        for (int i = 0; i < B.length; i++) {
            int r1 = B[i];
            int c1 = C[i];
            int r2 = D[i];
            int c2 = E[i];
            total = (sum[r2][c2] - sum[r1 - 1][c2] - sum[r2][c1 - 1] + sum[r1-1][c1 - 1]);
            total =  ((total % mod + mod) % mod);
            res[i] = (int) total;
        }
        return (res);
    }


}
