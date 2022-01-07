package dc.advance.Sorting2.reversion.assignment;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getWave(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(getWave(new int[]{1, 2})));
    }

    public static int[] getWave(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i += 2) {
            swap(A, i, i + 1);
        }
        return A;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[i + 1];
        a[i + 1] = temp;
    }
}
