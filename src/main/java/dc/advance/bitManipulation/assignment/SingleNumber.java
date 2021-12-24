package dc.advance.bitManipulation.assignment;

public class SingleNumber {

    /**
     * Given an array of integers A, every element appears twice except for one. Find that single one.
     */

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 2, 3, 1}));
    }

    public static int singleNumber(final int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res ^= A[i];
        }
        return res;
    }

}
