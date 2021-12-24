package dc.ProblemSolving2.HomeWork;

import java.util.Arrays;

public class ColumnSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[][]{{1}, {5}})));
    }

    private static int[] getSolve(int[][] A) {
       // System.out.println(A.length);
       // System.out.println(A[0].length);
        int[] res = new int[A[0].length];
        if (A.length == 1 && A[0].length == 1) {
            res[0] = A[0][0];
        }

        if (A.length == 2 && A[0].length == 1) {
            res[0] = A[0][0] + A[1][0];
        }

        for (int c = 0; c < A[0].length; c++) {
            int r = 0;
            int sum = 0;
            while (r < A.length) {
                sum += A[r][c];
                r++;
            }
            res[c] = sum;
        }
        return res;
    }

}
