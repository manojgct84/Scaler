package dc.advance.TwoPointer.reversion.homework;

public class Array3Pointers {
    public static void main(String[] args) {
        //System.out.println(minimize(new int[]{1, 4, 10}, new int[]{2, 15, 20}, new int[]{10,
        // 12}));
        //System.out.println(minimize(new int[]{3, 5, 6}, new int[]{2}, new int[]{3, 4}));
        System.out.println(minimize(new int[]{1, 4, 5, 8, 10}, new int[]{6, 9, 15}, new int[]{2, 3, 6, 6}));
    }

    public static int minimize(final int[] A, final int[] B, final int[] C) {
        int i = 0;
        int j = 0;
        int k = 0;
        int res = Integer.MAX_VALUE;
        while (i < A.length && j < B.length && k < C.length) {
            int min = Math.min(Math.abs(A[i]), Math.min(Math.abs(B[j]), Math.abs(C[k])));
            int max = Math.max(A[i], Math.max(B[j], C[k]));
            System.out.println("min " + min);
            System.out.println("max " + max);
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
