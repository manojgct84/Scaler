package dc.advance.bitManipulation.assignment;

import java.util.Arrays;

public class SingleNumberII {

    /**
     * Given an array of integers, every element appears thrice except for one which occurs once.
     * <p>
     * Find that element which does not appear thrice.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 9, 3, 3, 2, 2, 3, 1, 1}));
        System.out.println(singleNumber(new int[]{0, 0, 0, 1}));
    }

    public static int singleNumber(final int[] A) {
        int[] bits = new int[32];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((A[i] & (1 << j)) > 0) {
                    bits[j]++;
                    if (bits[j] == 3) {
                        bits[j] = (bits[j] % 3);
                    }
                    System.out.println(Arrays.toString(bits));
                }
            }
        }
        System.out.println("Final "+ Arrays.toString(bits));
        int decimalnumber = 0;
        int j = 0;
        while (j < bits.length) {
            decimalnumber += bits[j] * Math.pow(2, j);
            j++;
        }
        return decimalnumber;
    }
}
