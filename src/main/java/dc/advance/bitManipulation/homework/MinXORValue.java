package dc.advance.bitManipulation.homework;

import java.util.Arrays;

public class MinXORValue {

    public static void main(String[] args) {
        System.out.println(getFindMinXor(new int[]{0, 2, 5, 7}));
        System.out.println(getFindMinXor(new int[]{15, 5, 1, 10, 2}));
    }

    public static int getFindMinXor(int[] A) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 0; i < A.length-1; i++) {
            val = A[i] ^ A[i + 1];
            if (val < min) {
                min = val;
            }
        }
        //  System.out.println(min);
        return min;
    }
}
