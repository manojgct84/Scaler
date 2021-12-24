package dc.advance.Sorting2.assignment;

import java.util.Arrays;

public class MaximumMinimumMagic {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{3, 11, -1, 5})));
        System.out.println(Arrays.toString(getSolve(new int[]{-98, 54, -52, 15, 23, -97, 12, -64, 52, 85})));
    }

    static int mod = (1000000007);
    public static int[] getSolve(int[] A) {
        int[] res = new int[2];
        int mid = A.length / 2;
        long min = 0;
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        for (int k = 0; k < A.length - 1; k += 2) {
            //min = (min % mod + Math.abs(A[k] - A[k + 1]) % mod) % mod;
            min = min + Math.abs(A[k] - A[k + 1]);
        }


        int[] left = Arrays.copyOfRange(A, 0, mid);
        int[] right = Arrays.copyOfRange(A, mid, A.length);
        int i = 0;
        int j = right.length - 1;
        long max = 0;

        while (i < left.length && j >= 0) {
            //max = (max % mod + Math.abs(left[i] - Math.abs(right[j]))) % mod;
            max = max + Math.abs(left[i] - Math.abs(right[j]));
            i++;
            j--;
        }
        System.out.println("max " + max + " min " + min);
        res[0] = (int) (max % mod);
        res[1] = (int) (min % mod);
        return res;
    }
}
