package dc.Problem.Solving3.Assignment;

import java.util.Arrays;

public class MinimumDifferencePuzzle {
    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{759, 106, 827, 279, 722, 954, 80, 577, 273, 538, 963, 296, 693, 694, 684, 406, 603, 192, 166, 233, 310, 969, 980, 36, 322, 409, 392, 824, 422, 729, 76, 532, 186, 902, 811, 907, 855}, 16));
    }

    private static int getSolve(int[] A, int B) {

        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);

        if (A.length == 2) {
            return A[1] - A[0];
        }
        int min = Integer.MAX_VALUE;
       // System.out.println(Arrays.toString(A));
        for (int i = 0; i < B; i++) {
            if ((i + B) < A.length) {
                min = Math.min(min, A[i + B - 1] - A[i]);
               // System.out.println(min);
            }
            i = i + B;
        }

        int i = 1;
        while (i <= A.length - B) {
              //  System.out.println(A[i]);
             //   System.out.println(A[i + B - 1]);
                min = Math.min(min, A[i + (B - 1)] - A[i]);
                System.out.println(min);
            i++;
        }
        return min;
    }

}
