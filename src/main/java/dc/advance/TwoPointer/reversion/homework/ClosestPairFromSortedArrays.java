package dc.advance.TwoPointer.reversion.homework;

import java.util.Arrays;

public class ClosestPairFromSortedArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 6, 8}, 9)));
        System.out.println(Arrays.toString(solve(new int[]{5, 10, 20}, new int[]{1, 2, 30}, 13)));
        System.out.println(Arrays.toString(solve(new int[]{1}, new int[]{2, 4}, 4)));
        System.out.println(Arrays.toString(solve(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 10}, 10)));
    }

    public static int[] solve(int[] A, int[] B, int C) {
        int l = 0;
        int r = B.length - 1;
        int prev = Integer.MAX_VALUE;
        int A_VALUE = 0;
        int[] res = new int[2];
        while (l < A.length && r >= 0) {
            int a = A[l];
            int b = B[r];
            int diff = Math.abs(Math.abs(a + b) - C);
            if (diff < prev) {
                prev = diff;
                A_VALUE = A[l];
                res[0] = A[l];
                res[1] = B[r];
            }

            if (A_VALUE == A[l] && diff == prev) {
                res[1] = B[r];
            }
            if (Math.abs(a + b) < C) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

}
