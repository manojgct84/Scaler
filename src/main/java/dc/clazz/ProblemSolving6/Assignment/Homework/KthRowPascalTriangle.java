package dc.clazz.ProblemSolving6.Assignment.Homework;

import java.util.Arrays;

public class KthRowPascalTriangle {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(3)));
    }

    private static int[] getSolve(int A) {
        //nCr - Same as the number of paths in the matrix.
        int prev = 1;
        int[] result = new int[A + 1];
        result[0] = 1;
        for (int r = 1; r <= A; r++) {
            int res = (prev * (A - r + 1));
            res /= r;
            result[r] = res;
            prev = res;
        }
        return result;
    }
}
