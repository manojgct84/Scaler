package dc.advance.Sorting1.reversion.homework;

import java.util.Arrays;

public class WaveArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(wave(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(wave(new int[]{1, 2})));
    }

    public static int[] wave(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i += 2) {
            int temp = A[i];
            A[i] = A[i + 1];
            A[i + 1] = temp;
        }
        return A;
    }
}
