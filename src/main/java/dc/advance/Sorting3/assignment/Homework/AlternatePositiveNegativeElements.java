package dc.advance.Sorting3.assignment.Homework;

import java.util.Arrays;

public class AlternatePositiveNegativeElements {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(getSolve(new int[]{-1, -2, -3, 4, 5})));
        //System.out.println(Arrays.toString(getSolve(new int[]{-17, 5, -100, -11})));
/*
        System.out.println(Arrays.toString(getSolve(new int[]{-23, -24, -1, -25, 22, 1, 22, -28, 0,
                3, -24, 6, 0, -23, 7, 5, 17, 18, 14, 5, 20, -25, -13, 26, 13, -29, -7, 5, -4, 9,
                -30, 20, 11, -11, 22, 1, -19, 24, -15, 3, 17, -28, 30, -20, 30, 20, -14, -28, 18,
                10, -28, -25, -12, -21, 15, 0, 6, -15, 25, -25, 13, -24, 14, -22, 9, -23, 5, -12,
                6, -11, -12, 10, -12, -2, -8, 4, 17, -11, -4, 18, 11, -1, 1, -21, 14, -11, -18, 19,
                17, 9, -5, 8, -3, -6, -18, 19, -18, -5, -8, -29, -4, -27, 12, 2, 30, 8, 19, 11, -16,
                20, -22, 8, -27, -15, -12, 9, -10, 10, 22, 16, -9, -12, 9, -28, 2, 18, -28, -26, 21,
                27, -18, -13, -17, 20, 2, 11, 16, -11})));
*/

        System.out.println(Arrays.toString(getSolve(new int[]{ 24, -8, 7, 20, -19, -13, -3, 25, -10,
                10, -25, 7, 22, -15, 23, 6, -2, 26, 10, -14, -8, 5, -7, 27, 19, 15, -28, -30, 9, -19,
                -30, -2, -27, -9, 4, 14, -8, -4, 15, 24, -8, -27, -16, -11, 1, 18, -2, -5, 9, 28,
                -23, 23, -26, 8, -17, 20, -7, 5, -18, 8, -24, -20, 20, -28, -3, -18, 1, -8, 26,
                14, -6, 15, 9, 12, -1, 29, -12, -3, 8, 23, -21, 0, -7, -4, -25, -18, -12, -17,
                -15, -11, -3, -29, -13, 10, 1, 11, 11, 15, -9, -29, 12, -21, -17, 1, 7, 11, 7, 15,
                21, -4, -20, 17, -8, 1, -3, 28, -8, -29, 9, 29, 26, -16, -21, -23, -5, 25, -13, -1,
                -29, 25, 17, 3, 11, 26, 14, -30, 12, -4, 29, 21, -25, 8, -4, 11, -28, -16, -26})));
    }

    public static int[] getSolve(int[] A) {
        int i = 0;
        int j;

        while (i < A.length) {
            j = i + 1;
            if (i % 2 == 0) {
                if (A[i] >= 0) {
                    while (j < A.length && A[j] >= 0) {
                        j++;
                    }
                    if (swap(A, i, j)) {
                        break;
                    }
                }
            } else {
                if (A[i] < 0) {
                    while (j < A.length && A[j] < 0) {
                        j++;
                    }
                    if (swap(A, i, j)) {
                        break;
                    }
                }
            }
            i++;
        }
        return A;
    }

    private static boolean swap(int[] A, int i, int j) {
        if (j > A.length - 1) {
            return true;
        }
        while (j > i) {
            int tmp = A[j];
            A[j] = A[j - 1];
            A[j - 1] = tmp;
            j--;
        }
        return false;
    }
}
