package dc.clazz.ProblemSolving6.Assignment;

import java.util.Arrays;

public class Bulbs {

    public static void main(String[] args) {
        System.out.println(getBulbs(new int[]{0, 1, 0, 1}));
    }

    public static int getBulbs(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (res % 2 != 0) {
                A[i] = (A[i] + 1) % 2;
               /* if (A[i] == 0) {
                    A[i] = 1;
                } else {
                    A[i] = 0;
                }*/
            }
            if (A[i] == 0) {
                res++;
            }

            System.out.println(Arrays.toString(A));
        }
        return res;
    }
}
