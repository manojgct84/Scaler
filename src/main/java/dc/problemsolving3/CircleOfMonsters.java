package dc.problemsolving3;

public class CircleOfMonsters {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 2}, new int[]{2, 1}));
    }

    public static int getSolve(int[] A, int[] B) {
        long maxButts = Math.max(0, A[0] - B[B.length - 1]);
        long M = 1000000007;
        for (int i = 1; i < A.length; i++) {
            maxButts = maxButts % M + (Math.max(0, A[i] - B[i - 1]) % M);
        }
        System.out.println(maxButts);
        long minButts = maxButts - Math.max(0, A[0] - B[B.length - 1]) + A[0];

        for (int i = 1; i < A.length; i++) {
            minButts = Math.min(minButts, maxButts - Math.max(0, A[i] - B[i - 1]) + A[i]);
        }
        return (int) (minButts % M);
    }
}
