package dc.problemsolving3.Homework;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{-4, 3}, new int[]{-2, -2})));
    }

    public static int[] getSolve(final int[] A, final int[] B) {

        if (A.length == 0) {
            return B;
        }

        if (B.length == 0) {
            return A;
        }

        int i = 0;
        int j = 0;
        int index = 0;

        int total = A.length + B.length;
        int[] res = new int[total];
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                res[index] = A[i];
                i++;
            } else {
                System.out.println(B[j]);
                res[index] = B[j];
                j++;
            }
            index++;
        }

        if (i != A.length) {
            System.out.println("i " + i);
            System.out.println("A " + A.length);
            while (i < A.length) {
                res[index] = A[i];
                index++;
                i++;
            }
        }

        if (j != B.length) {
            System.out.println("j " + j);
            while (j < B.length) {
                res[index] = B[j];
                index++;
                j++;
            }
        }
        return res;
    }
}
