package dc.advance.Sorting1.reversion.homework;

import java.util.Arrays;

public class MaxMod {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 44, 3}));
        System.out.println(solve(new int[]{2, 6, 4}));
        System.out.println(solve(new int[]{1, 2, 3, 3}));
    }

    public static int solve(int[] A) {
        //TC O(NlogN)
        Arrays.sort(A);
        int i = A.length - 1;
        int j = A.length - 2;

        while (j >= 0) {
            if (A[i] != A[j]) {
                return A[j] % A[i];
            } else {
                i--;
                j--;
            }
        }
        int first = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;
        //Other Approach  TC O(N)
        for (int k = 0; k < A.length; k++) {
            if (first < A[k]) {
                sec = first;
                first = A[k];
            } else if (sec < A[k] && first != A[k] && sec != first) {
                sec = A[k];
            }
        }
        if (sec == Integer.MIN_VALUE) {
            return 0;
        }
        return sec;
    }
}
