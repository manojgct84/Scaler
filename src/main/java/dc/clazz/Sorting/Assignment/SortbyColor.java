package dc.clazz.Sorting.Assignment;

import java.util.Arrays;

public class SortbyColor {

    public static void main(String[] args) {
        System.out.println((Arrays.toString(getSolution(new int[]{0}))));
    }

    private static int[] getSolution(int[] A) {

        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int value : A) {
            if (value == 0) {
                zeros++;
            }
            if (value == 1) {
                ones++;
            }
            if (value == 2) {
                twos++;
            }
        }
        int j = 0;
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (i < zeros) {
                A[i] = 0;
                j = i;
                continue;
            }
            if (i < (ones + j + 1)) {
                A[i] = 1;
                k = i;
                continue;
            }
            if (i < (twos + k + 1)) {
                A[i] = 2;
            }
        }
        return A;
    }
}
