package dc.advance.Sorting1.reversion.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallestElement {

    public static void main(String[] args) {
        System.out.println(getKthSmallest(new int[]{2, 1, 4, 3, 2}, 3));
        System.out.println(getKthSmallest(new int[]{2, 1}, 2));
    }

    public static int getKthSmallest(final int[] A, int B) {

        int i = 0;
        int prev = -1;

        while (i <= B) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < A.length; j++) {
                min = Math.min(min, A[j]);
                //System.out.println("min " + min);
                if (min != prev) {
                    int temp = A[j];
                    if (j != i && A[i] == A[j]) {
                        A[j] = A[i + 1];
                        A[i + 1] = temp;
                    } else {
                        A[j] = A[i];
                        A[i] = temp;
                    }
                    prev = min;
                }
            }
            i++;
        }
        System.out.println(Arrays.toString(A));
        return A[B - 1];
    }
}
