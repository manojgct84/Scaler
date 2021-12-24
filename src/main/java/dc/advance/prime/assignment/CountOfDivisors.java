package dc.advance.prime.assignment;

import java.util.Arrays;

public class CountOfDivisors {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{2, 3, 4, 5})));
    }

    public static int[] getSolve(int[] A) {

        int[] sf = new int[15];

        for (int i = 1; i < 15; i++) {
            sf[i] = i;
        }

        System.out.print(Arrays.toString(sf));
        for (int i = 2; i * i < 15; i++) {
            if (sf[i] == i) {
                for (int j = i * i; j < 15; j = i + j) {
                    if (sf[j] == i) {
                        sf[j] = i;
                    }
                }
            }
            System.out.print(Arrays.toString(sf));
        }

        int[] count = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int fact = 1;
            int val = A[i];

            while (val != 1) {
                int x = 1;
                int div = sf[val];
                while (val % div != 0) {
                    x++;
                    val /= div;
                }
                fact *= x;
            }
            count[i] = fact;
        }
        return count;
    }
}
