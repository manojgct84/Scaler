package dc.advance.array2.HomeWork;

import java.util.Arrays;

public class MinimumSwaps2 {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{2, 0, 1, 3}));
    }

    public static int getSolve(int[] A) {

        int i = 0;
        int swapCount = 0;

        while (i < A.length) {
            int val = A[i];
            if (A[i] != i) {
                int temp = A[val];
                A[val] = A[i];
                A[i] = temp;
                swapCount++;
                i--;
            }
            System.out.println(Arrays.toString(A));
            i++;
        }
        return swapCount;
    }
}
