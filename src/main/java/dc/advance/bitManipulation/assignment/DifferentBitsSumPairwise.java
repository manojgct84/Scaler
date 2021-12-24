package dc.advance.bitManipulation.assignment;

public class DifferentBitsSumPairwise {

    public static void main(String[] args) {
        System.out.println(cntBits(new int[]{1, 3, 5}));
    }

    public static int cntBits(int[] A) {
        return getSolve(A);
    }

    public static int getSolve(int[] A) {

        int mod = 1000000007;
        int n = A.length;
        long total = 0;
        for (int i = 0; i < 32; i++) {
            int setBits = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (1 << i)) > 0) {
                    setBits++;
                }
            }
            total += 2 * (long)setBits * (n - (long)setBits);
            total = (total % mod);
        }
        return (int) (total);
    }
}
