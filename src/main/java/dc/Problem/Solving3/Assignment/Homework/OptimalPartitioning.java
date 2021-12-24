package dc.Problem.Solving3.Assignment.Homework;

import java.util.Arrays;

public class OptimalPartitioning {
    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{2, 1, 3, 2, 4, 3}));
    }

    private static int getSolve(int[] A) {
        Arrays.sort(A);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] < diff) {
                diff = Math.min(diff, A[i + 1] - A[i]);
            }
        }
        return diff;
    }
}
