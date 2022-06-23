package dc.clazz.matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class Rotate90 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getSolution(
                new int[][]{{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}})));
    }

    private static int[][] getSolution(int[][] A) {
        if (A[0].length == 1) {
            int[][] res = new int[1][1];
            res[0][0] = 1;
            return res;
        }

        int[][] res = new int[A[0].length][A.length];
        int row_start = 0;
        int row_end = A.length;
        int col_start = 0;
        int col_end = A.length;
        int m = col_end - 1;
        while (row_start < row_end) {
            int r = 0;
            for (int c = col_start; c < col_end; c++) {
                res[r++][m] = A[row_start][c];
            }
            m--;
            row_start++;
        }
        for (int i = 0; i < res.length; i++) {
            System.arraycopy(res[i], 0, A[i], 0, res[0].length);
        }
        return res;
    }


    public void solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        if (n == 0)
            return;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - layer - 1;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;
                int top = A.get(layer).get(i);
                A.get(layer).set(i, A.get(last - offset).get(layer));
                A.get(last - offset).set(layer, A.get(last).get(last - offset));
                A.get(last).set(last - offset, A.get(i).get(last));
                A.get(i).set(last, top);
            }
        }
    }
}
