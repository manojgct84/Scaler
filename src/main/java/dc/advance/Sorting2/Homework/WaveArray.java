package dc.advance.Sorting2.Homework;

import java.util.Arrays;

public class WaveArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getWave(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(getWave(new int[]{1, 2})));
    }

    public static int[] getWave(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i += 2) {
            swapValues(i, i + 1, A);
        }
        return A;
    }

    private static void swapValues(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
