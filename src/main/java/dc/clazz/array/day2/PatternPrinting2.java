package dc.clazz.array.day2;

import java.util.Arrays;

public class PatternPrinting2 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getSolve(3)));
    }

    private static int[][] getSolve(int A) {
        int[][] res = new int[A][A];

        for (int row = 0; row < A; row++) {
            int col = 0;
            while (col <= row) {
                res[row][A - col - 1] = col + 1;
                col++;
            }
        }
        return res;
    }
}
