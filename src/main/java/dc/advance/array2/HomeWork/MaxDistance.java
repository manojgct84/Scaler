package dc.advance.array2.HomeWork;

import java.util.Arrays;

public class MaxDistance {

    public static void main(String[] args) {
        System.out.println(getmaximumGaptSolve(new int[]{3, 4, 5, 2}));
    }

    public static int getmaximumGaptSolve(final int[] A) {

        int[] LMIN = new int[A.length];
        int[] RMAX = new int[A.length];
        LMIN[0] = A[0];
        for (int i = 1; i < A.length; ++i) {
            LMIN[i] = Integer.min(LMIN[i - 1], A[i]);
        }
        RMAX[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; --i) {
            RMAX[i] = Integer.max(RMAX[i + 1], A[i]);
        }
        System.out.println(Arrays.toString(LMIN) + " " + Arrays.toString(RMAX));

        int i = 0;
        int j = 0;
        int res = Integer.MIN_VALUE;
        while (i < LMIN.length && j < RMAX.length) {
            if (LMIN[i] <= RMAX[j]) {
                res = Math.max(res, j - i);
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}
