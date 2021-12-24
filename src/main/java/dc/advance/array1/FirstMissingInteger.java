package dc.advance.array1;

import java.util.Arrays;

public class FirstMissingInteger {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
    }

    public static int firstMissingPositive(int[] A) {
        //1, 2, 0
        for (int i = 0; i < A.length; i++) {
            System.out.println("A[i] " + A[i] + " i + 1 " + (i + 1));
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] >= A.length) break;
                if (A[A[i] - 1] == A[i]) break; // duplicate check
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(A));
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
