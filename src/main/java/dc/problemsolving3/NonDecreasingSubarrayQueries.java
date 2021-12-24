package dc.problemsolving3;

import java.util.Arrays;

public class NonDecreasingSubarrayQueries {

    public static void main(String[] args) {
/*        System.out.println(Arrays.toString(getSolve(new int[]{7, 7, 1, 6, 9},
                new int[][]{
                        {1, 3}
                        , {4, 5}
                        , {1, 2}
                        , {3, 4}
                        , {1, 5}

                })));*/

        System.out.println(Arrays.toString(getSolve(new int[]{2, 2, 5, 1},
                new int[][]{
                        {2, 4}
                        , {5, 2}
                })));
    }

    public static int[] getSolve(int[] A, int[][] B) {

        int[] index = new int[A.length];
        int[] prefixSum = new int[A.length];
        index[0] = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) {
                index[i] = 0;
            } else {
                index[i] = 1;
            }
        }
        System.out.println(Arrays.toString(index));
        prefixSum[0] = index[0];
        for (int j = 1; j < index.length; j++) {
            prefixSum[j] = prefixSum[j - 1] + index[j];
        }
        System.out.println(Arrays.toString(prefixSum));
        System.out.println("ans len: " + B.length);
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int qF = B[i][0];
            int qS = B[i][1];
            int a = prefixSum[qS - 1] - prefixSum[qF - 1];
            if (a > 0) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
