package dc.clazz.Sorting.Assignment;

import java.util.Arrays;

public class KthSmallestElement {
    public static void main(String[] args) {
        System.out.println((getSolution(new int[]{3, 22, 23, 86, 59, 61, 53, 77, 18, 32, 25, 21, 10, 35, 70, 43, 39, 60, 99, 1, 4, 3, 86, 38, 78, 87, 94, 5}, 4)));

    }

    //1,2
    //j =2 , i=
    private static int getSolution(int[] A, int B) {

        if (B <= 0 || A.length == 0) {
            return 0;
        }

        if (B > A.length) {
            return 0;
        }

        Arrays.sort(A);

        for (int j = 0; j < B; j++) {
            for (int i = j + 1; i < A.length; i++) {
                if (A[j] > A[i]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    System.out.println(Arrays.toString(A));
                   /* if (j != 0 && A[j - 1] != A[i]) {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        System.out.println(Arrays.toString(A));
                    } else if (j == 0) {

                    }*/
                }
            }

        }
        return A[B - 1];
    }
}
