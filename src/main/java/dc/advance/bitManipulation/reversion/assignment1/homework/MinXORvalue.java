package dc.advance.bitManipulation.reversion.assignment1.homework;

import java.util.Arrays;

public class MinXORvalue {

    public static void main(String[] args) {
        System.out.println(findMinXor(new int[]{0, 2, 5, 7}));
        System.out.println(findMinXor(new int[]{0, 4, 7, 9}));
    }

    public static int findMinXor(int[] A) {
        Arrays.sort(A);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            res = Math.min(A[i] ^ A[i + 1], res);
        }
        return res;
    }

}


