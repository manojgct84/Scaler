package dc.advance.array1;

import java.util.Arrays;

public class RainWaterTrapped {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{1,2}));
    }

    public static int trap(final int[] A) {

        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            left[i] = Math.max(left[i -1], A[i]);
        }
        right[A.length-1] = A[A.length-1];
        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+ 1], A[i]);
        }

         System.out.println(Arrays.toString(left));
         System.out.println(Arrays.toString(right));

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count += Math.min(left[i], right[i]) - A[i];
        }
        return count;
    }
}
