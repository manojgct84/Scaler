package dc.resursion;

import java.util.Arrays;

public class BackTrackBook {
    static int n = 5;
    static int[] a = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        binary(n);
    }

    private static void binary(int n) {

        if (n < 1) {
            System.out.println(Arrays.toString(a));
        } else {
            a[n - 1] = 0;
            binary(n - 1);
            a[n - 1] = 1;
            binary(n - 1);
        }
    }
}
