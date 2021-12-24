package dc.problemsolving3;

import java.util.Arrays;

public class WhenAntsDie {

    public static void main(String[] args) {
        System.out.println(getSolve(5, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}));
    }

    private static int getSolve(int n, int[] left, int[] right) {

        if (left.length == 0) {
            Arrays.sort(right);
            return right[0];
        }

        if (right.length == 0) {
            Arrays.sort(left);
            return left[left.length - 1];

        }

        int leftMax = 0;
        for (int i = 0; i < left.length; i++) {
            leftMax = Math.max(left[i], leftMax);
        }
        int rightMax = 0;
        for (int i = 0; i < right.length; i++) {
            rightMax = Math.max(n - right[i], rightMax);
        }
        return Math.max(rightMax, leftMax);
    }
}