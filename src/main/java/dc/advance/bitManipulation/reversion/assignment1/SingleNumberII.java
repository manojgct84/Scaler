package dc.advance.bitManipulation.reversion.assignment1;

public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 4, 3, 3, 2, 2, 3, 1, 1}));
        System.out.println(singleNumber(new int[]{0, 0, 0, 1}));
    }

    public static int singleNumber(final int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (1 << i)) > 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                res += (1 << i);
            }
        }
        return res;
    }
}
