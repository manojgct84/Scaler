package dc.advance.bitManipulation.reversion.assignment1.homework;

public class DifferentBitsSumPairwise {
    public static void main(String[] args) {
        System.out.println(cntBits(new int[]{1, 3, 5}));
    }

    public static int cntBits(int[] A) {

        int mod = 1000000007;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cntBits = 0;
            for (int j = 0; j < A.length; j++) {
                // if ((A[j] & (1 << i)) > 0) {
                // both are same
                if (((A[j] >> i) & 1) == 1) {
                    cntBits++;
                }
            }
            res = (int) (res % mod + (long) cntBits * (A.length - (long) cntBits) % mod);
        }
        return (res * 2) % mod;
    }
}
