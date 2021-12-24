package dc.advance.bitManipulation.reversion.assignment2;

import java.util.Arrays;

public class SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1, 2, 3, 1, 2, 4})));
        System.out.println(Arrays.toString(solve(new int[]{1, 2})));
    }

    public static int[] solve(int[] A) {
        int XOR = 0;
        for (int i = 0; i < A.length; i++) {
            XOR ^= A[i];
        }
        System.out.println("XOR " + XOR);

        int pos = 0;
        for (int i = 0; i < 32; i++) {
            if ((XOR & (1 << i)) > 0) {
                pos = i;
            }
        }
        int first = 0, second = 0;

        for (int i = 0; i < A.length; i++) {
            // if (((A[i] >> pos) & 1) == 1) {// We check with one it is becasue >> will remove the LSB bits.
            if ((A[i] & (1 << pos)) > 0) {// We check with > 0 is becasue << will add MSB and value will reamin the same.
                first ^= A[i];
            } else {
                second ^= A[i];
            }
        }
        return new int[]{first, second};
    }
}
