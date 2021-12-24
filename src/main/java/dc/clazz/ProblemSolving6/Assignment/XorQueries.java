package dc.clazz.ProblemSolving6.Assignment;

import java.util.Arrays;

public class XorQueries {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getSolve(new int[]{1, 0, 0, 0, 1}, new int[][]{{2, 4}, {1, 5}, {3, 5}})));
    }

    public static int[][] getSolve(int[] A, int[][] B) {
        int[] pfSum = new int[A.length + 1];
        pfSum[0] = 0;

        for (int i = 0; i < A.length; i++) {
            pfSum[i + 1] = A[i] + pfSum[i];
        }
        System.out.println(Arrays.toString(pfSum));
        int[][] res = new int[B.length][B[0].length];
        for (int i = 0; i < B.length; i++) {
            int fQ = B[i][0];
            int sQ = B[i][1];
            int a = pfSum[sQ] - pfSum[fQ - 1];
            //res[i][0] = a % 2 == 0 ? 0 : 1;
            res[i][0] = (a & 1) == 0 ? 0 : 1;
            int diff = (sQ - fQ) + 1;
            System.out.println("diff " + diff + "a " + a);
            res[i][1] = Math.abs(diff - a);
            System.out.println(Arrays.deepToString(res));
        }
        return res;
    }
}