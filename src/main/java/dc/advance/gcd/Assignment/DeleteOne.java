package dc.advance.gcd.Assignment;

import java.util.Arrays;

public class DeleteOne {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{7, 21}));
    }

    public static int getSolve(int[] A) {

        int[] prefix = new int[A.length];
        int[] suffix = new int[A.length];
        prefix[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefix[i] = gcd(prefix[i - 1], A[i]);
        }
        suffix[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], A[i]);
        }

        System.out.println(Arrays.toString(prefix) + " " + Arrays.toString(suffix));

        int i = 1;
        int j = 1;
        int ans = 0;

        while (i < prefix.length && j < suffix.length - 1) {
            ans = Math.max(ans, gcd(prefix[i - 1], suffix[j + 1]));
            i++;
            j++;
        }
        if (ans == 0 && A.length == 2) {
            ans = Math.max(A[0], A[1]);
        }
        return ans;
    }


    private static int gcd(int A, int B) {

        while (B > 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        //  System.out.println(A);
        return A;
    }
}
