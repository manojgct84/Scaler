package dc.clazz.problem.solving1;

import java.util.Arrays;

public class BeggarsOutsideTemple {
    /**
     * Input:
     * N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
     * <p>
     * Return: [10, 55, 45, 25, 25]
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(5, new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}})));
    }

    public static int[] getSolve(int A, int[][] B) {
        int[] lst = new int[A];
        for (int i = 0; i < A; i++) {
            lst[i] = 0;
        }

        for (int i = 0; i < B.length; i++) {
            int j = 0;
            int index_1 = 0;
            int index_2 = 0;
            int value = 0;
            // while (j < 1) {
            if (j < B[0].length) {
                index_1 = B[i][j];
            }
            if (j + 1 < B[0].length) {
                index_2 = B[i][j + 1];
            }
            if (j + 2 < B[0].length) {
                value = B[i][j + 2];
            }
            for (int k = index_1; k <= index_2; k++) {
                lst[k - 1] = lst[k - 1] + value;
            }
            //     j++;
            // }
        }
        return lst;
    }

    //TC O(ROW * N);
}
