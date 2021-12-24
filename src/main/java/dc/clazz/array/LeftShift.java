package dc.clazz.array;

import java.util.Arrays;

public class LeftShift {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getSolve(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3})));
    }

    private static int[][] getSolve(int[] A, int[] B) {
        int[][] matrix = new int[B.length][A.length];
        if (B[0] == 0 && B.length == 1) {
            int j = 0;
            while (j < A.length) {
                matrix[0][j] = A[j];
                j++;
            }
        }

        //List<List<Integer>> matrix = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < B.length; i++) {
            int[] result = rotate(Arrays.copyOf(A, A.length), B[i]);
            while (j < result.length) {
                matrix[i][j] = result[j];
                j++;
            }
            j = 0;
        }
        return matrix;
    }

    private static int[] rotate(int[] a, int k) {
        for (int i = 0; i < k; i++) {
            int j = 0;
            int temp = a[0];
            while (j < a.length - 1) {
                a[j] = a[j + 1];
                j++;
            }
            a[j] = temp;
        }
        return a;
    }
}