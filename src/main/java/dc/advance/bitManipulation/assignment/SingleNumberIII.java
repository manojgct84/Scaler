package dc.advance.bitManipulation.assignment;

import java.util.Arrays;

public class SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoDifferentNumber(new int[]{1, 2, 3, 1, 2, 4})));
    }

    private static int[] twoDifferentNumber(int[] ints) {
        int xor = 0;

        for (int anInt : ints) {
            xor ^= anInt;
        }
        // position at which the bit is set '1'
        int pos = 0;
        for (int i = 0; i < 31; i++) {
            if ((xor & (1 << i)) > 0) {
                pos = i;
                break;
            }
        }

        int first = 0, second = 0;
        for (int anInt : ints) {
            if (((anInt >> pos) & 1) == 1) {
                first ^= anInt;
            } else
                second ^= anInt;
        }
        if (first < second) {
            return new int[]{first, second};
        }
        return new int[]{second, first};
        // System.out.println(first + " " + second);
    }
}
