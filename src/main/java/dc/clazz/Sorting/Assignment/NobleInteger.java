package dc.clazz.Sorting.Assignment;

import java.util.Arrays;

public class NobleInteger {
    public static void main(String[] args) {
        System.out.println((getSolution(new int[]{1, 2, 7, 0, 9, 3, 6, 0, 6})));
    }

    private static int getSolution(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                continue;
            }

            if (A[i] == A.length - 1 - i) {
                return 1;
            }
        }

        if (A[A.length - 1] == 0) {
            return 1;
        }
        return -1;
    }

}


