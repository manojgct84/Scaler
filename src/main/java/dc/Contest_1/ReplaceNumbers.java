package dc.Contest_1;

import java.util.Arrays;

public class ReplaceNumbers {
    /**
     * You have a array A and B with Query, In the ith Operation replace B[i][0] with some B[i][1]
     */


    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{2, 2, 5, 1}, new int[][]{{2, 4}, {5, 2}})));
    }

    private static int[] getSolve(int[] A, int[][] B) {
        if (A.length == 0) {
            return A;
        }

        if (B.length == 0 || B[0].length == 0) {
            return A;
        }

        for (int i = 0; i < B.length; i++) {
            int qF = B[i][0];
            int qS = B[i][1];
            int j = 0;
            while (j < A.length) {
                if (A[j] == qF) {
                    A[j] = qS;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(A));
        return A;
    }
}
