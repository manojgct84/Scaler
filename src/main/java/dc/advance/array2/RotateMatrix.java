package dc.advance.array2;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getSolution(new int[][]{{1, 2, 3},
                                                                       {4, 5, 6},
                                                                       {7, 8, 9}})));
    }

    private static int[][] getSolution(int[][] A) {
        int[][] res = new int[A.length][A[0].length];
        if (A[0].length == 1) {
            res[0][0] = 1;
            return res;
        }
        int n = A[0].length - 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res[j][n - i] = A[i][j];
            }
        }

        for (int i = 0; i < res.length; i++) {
            System.arraycopy(res[i], 0, A[i], 0, res[0].length);
        }
        return A;
    }
}
