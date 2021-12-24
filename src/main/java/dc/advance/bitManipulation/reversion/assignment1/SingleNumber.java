package dc.advance.bitManipulation.reversion.assignment1;

public class SingleNumber {

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

