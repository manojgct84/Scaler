package dc.clazz.matrix;

import java.util.Arrays;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getSolution(4)));
    }

    private static int[][] getSolution(int A) {
        int[][] res = new int[A][A];
        if (A == 0) {
            return res;
        }
        res[0][0] = 1;
        for (int i = 1; i < A; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    res[i][j] = res[i - 1][j];
                } else {
                    res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
                }
            }
        }
        return res;
    }
}
