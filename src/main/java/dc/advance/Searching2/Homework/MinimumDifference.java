package dc.advance.Searching2.Homework;

import java.util.Arrays;

public class MinimumDifference {


    public static void main(String[] args) {
        System.out.println(getSolve(2, 2, new int[][]{{8, 4}, {6, 8}}));
        System.out.println(getSolve(2, 2, new int[][]{{8, 4}, {6, 8}}));
    }

    public static int getSolve(int A, int B, int[][] C) {
        for (int[] a : C) {
            Arrays.sort(a);
        }
        int res = Integer.MAX_VALUE;
        for (int r = 0; r < A - 1; r++) { // Last row you cannot calculate the difference.
            for (int c = 0; c < B; c++) {
                int low = 0;
                int high = B - 1;
                int t = C[r][c];
                int lower = -1;
                int upper = -1;
                while (low <= high) {
                    int mid = low + ((high - low) >> 1);
                    if (C[r + 1][mid] == t) {
                        return 0;
                    }
                    if (C[r + 1][mid] < t) {
                        low = mid + 1;
                        lower = C[r + 1][mid];
                    } else {
                        high = mid - 1;
                        upper = C[r + 1][mid];
                    }
                }
                if (lower != -1 && upper != -1) {
                    res = Math.min(res, Math.min(t - lower, upper - t));
                } else if (lower != -1) {
                    res = Math.min(res, t - lower);
                } else if (upper != -1) {
                    res = Math.min(res, upper - t);
                }
            }
        }
        return res;
    }
}
