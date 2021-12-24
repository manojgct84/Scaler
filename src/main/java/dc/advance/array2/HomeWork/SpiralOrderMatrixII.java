package dc.advance.array2.HomeWork;

import java.util.Arrays;

public class SpiralOrderMatrixII {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getSolution(80)));
    }

    private static int[][] getSolution(int A) {
        if (A == 1) {
            int[][] res = new int[1][1];
            res[0][0] = 1;
            return res;
        }

        int[][] res = new int[A][A];
        int row_start = 0;
        int row_end = A;
        int col_start = 0;
        int col_end = A;
        //end = A * A;
        int fill = 0;
        while (row_start < row_end && col_start < col_end) {

            for (int c = col_start; c < col_end /*&& fill <= end*/; c++) {
                res[row_start][c] = ++fill;
                //System.out.println("1: " + fill);
            }
            row_start++;

            for (int r = row_start; r < row_end /*&& fill <= end*/; r++) {
                res[r][col_end - 1] = ++fill;
                //System.out.println("2: " + fill);
            }
            col_end--;

            for (int c = col_end - 1; c >= col_start /*&& fill <= end*/; c--) {
                res[row_end - 1][c] = ++fill;
                //System.out.println("3: " + fill);
            }
            row_end--;

            for (int r = row_end - 1; r >= row_start /*&& fill <= end*/; r--) {
                res[r][col_start] = ++fill;
                //System.out.println("4: " + fill);
            }
            col_start++;
        }
        return res;
    }
}
