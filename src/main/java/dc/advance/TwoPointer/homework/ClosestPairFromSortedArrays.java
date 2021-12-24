package dc.advance.TwoPointer.homework;

import java.util.Arrays;

public class ClosestPairFromSortedArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 6, 8}, 9)));
        // System.out.println("------------");
        System.out.println(Arrays.toString(getSolve(new int[]{5, 10, 20}, new int[]{1, 2, 30}, 13)));
        System.out.println(Arrays.toString(getSolve(new int[]{1}, new int[]{2, 4}, 4)));
    }

    public static int[] getSolve(int[] A, int[] B, int C) {
        int i = 0;
        int j = B.length - 1;
        int[] res = new int[2];
        int k = A[0];
        int prev = Math.abs(A[i] + B[j] - C);
        while (i < A.length && j >= 0) {
            int l = A[i];
            int r = B[j];
            int current = Math.abs((l + r) - C);
            if (current < prev) {
                prev = current;
                k = A[i];
            }
            if (A[i] == k && current == prev) {
                res[1] = B[j];
            }

            if ((l + r) < C) {
                i++;
            } else {
                j--;
            }
            res[0] = k;
        }
        return res;
    }
}
