package dc.clazz.ProblemSolving6.Assignment;

public class SUBARRAYOR {
    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 2, 3, 4, 5}));
    }


    public static int getSolve(int[] A) {
        /**
         * 1 - 001
         * 2 - 010
         * 3 - 011
         * 4 - 100
         * 5 - 101
         *
         *  [1,0,1,0,1]
         *  [0,1,1,0,0]
         *  [0,0,0,1,1]
         *
         */
        int unsetBits = 0;
        int n = A.length;
        long total = 0;
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res = (long) n * (n + 1) / 2;
            for (int k : A) {
                System.out.println("Binary:" + Integer.toBinaryString(k));
                //if ((k & (1 << i)) > 0) { // (A[i] >> i) & 1 == 1
                if (((k >> i) & 1) == 1) {
                    res -= ((long) unsetBits * (unsetBits + 1)) / 2;
                    unsetBits = 0;
                } else {
                    unsetBits++;
                }
            }
            res -= ((long) unsetBits * (unsetBits + 1)) / 2;
            total += (long) (res * Math.pow(2, i) % 1000000007);
            System.out.println(total);
            unsetBits = 0;
        }
        return (int) (total % 1000000007);
    }
}
