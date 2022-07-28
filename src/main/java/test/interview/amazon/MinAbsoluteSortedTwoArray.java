package test.interview.amazon;

import java.util.Arrays;

public class MinAbsoluteSortedTwoArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minAbsoluteSortedTwoArray(
                new int[]{2, 6, 8, 10, 15}, new int[]{5, 7, 8, 11, 21})));
        System.out.println(Arrays.toString(minAbsoluteSortedTwoArray(
                new int[]{5, 7, 8, 11, 21}, new int[]{2, 6, 8, 10, 15})));
        System.out.println(Arrays.toString(minAbsoluteSortedTwoArray(
                new int[]{20, 21, 22, -25, 30}, new int[]{5, 7, 15, 20, 21})));
    }

    private static int[] minAbsoluteSortedTwoArray(int[] A, int[] B) {

        int i = 0;
        int j = 0;
        int diff = Integer.MAX_VALUE;
        int[] value = new int[3];
        while (i < A.length && j < B.length) {
            if (diff == 0) {
                return value;
            }
            if (diff > Math.abs(A[i] - B[i])) {
                value[0] = A[i];
                value[1] = B[i];
                diff = Math.abs(A[i] - B[i]);
                value[2] = diff;
                j++;
            } else {
                i++;
            }
        }
        return value;
    }
}
