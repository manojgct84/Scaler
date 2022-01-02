package dc.advance.TwoPointer.reversion.homework;

public class MinimizeAbsoluteDifference {
    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 4, 5, 8, 10}, new int[]{6, 9, 15}, new int[]{2, 3, 6, 6}));
    }

    public static int getSolve(int[] A, int[] B, int[] C) {
        int i = 0;
        int j = 0;
        int k = 0;
        int res = Integer.MAX_VALUE;
        while (i < A.length && j < B.length && k < C.length) {
            int min = Math.min(A[i], Math.min(B[j], C[k]));
            int max = Math.max(A[i], Math.max(B[j], C[k]));

            if (max == 0) {
                return 0;
            } else {
                res = Math.min(res, Math.abs(max - min));
            }
            if (A[i] == min) {
                i++;
            } else if (B[j] == min) {
                j++;
            } else {
                k++;
            }
        }
        return res;
    }
}
