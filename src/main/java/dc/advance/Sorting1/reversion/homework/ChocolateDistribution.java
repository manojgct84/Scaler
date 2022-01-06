package dc.advance.Sorting1.reversion.homework;

import java.util.Arrays;

public class ChocolateDistribution {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 4, 1, 9, 56, 7, 9, 12}, 5));
    }

    public static int solve(int[] A, int B) {
        if (B == 0 || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int min = 0;
        int i = 0;
        int k = 0;
        int prev = Integer.MAX_VALUE;
        while ((i + B - 1) < A.length) {
            /*if (k == B - 1) {
                break;
            }*/
            min = A[i + B - 1] - A[i];
            if (min < prev) {
                prev = min;
            }
            i++;
            // k++;
        }
        return prev;
    }
}
