package dc.advance.array1.Homework;

import java.util.Arrays;

public class AbsoluteMaximum {

    public static void main(String[] args) {
        System.out.println(getSolveProvidedByTA(new int[]{1, 2, 3, 4}, new int[]{-1, 4, 5, 6}, new int[]{-10, 5, 3, -8},
                new int[]{-1, -9, -6, -10}));
    }


    /*This is not working*/
    public static int getSolve(int[] A, int[] B, int[] C, int[] D) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;
        int max5 = Integer.MIN_VALUE;
        int max6 = Integer.MIN_VALUE;
        int max7 = Integer.MIN_VALUE;
        int max8 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        int min5 = Integer.MAX_VALUE;
        int min6 = Integer.MAX_VALUE;
        int min7 = Integer.MAX_VALUE;
        int min8 = Integer.MAX_VALUE;


        for (int i = 0; i < A.length; i++) {
            max1 = Math.max(max1, A[i] + B[i] + i);
            max2 = Math.max(max2, A[i] + B[i] - i);
            max3 = Math.max(max3, A[i] - B[i] + i);
            max4 = Math.max(max4, B[i] - A[i] - i);

            max5 = Math.max(max5, C[i] + D[i] + i);
            max6 = Math.max(max6, C[i] + D[i] - i);
            max7 = Math.max(max7, C[i] - D[i] + i);
            max8 = Math.max(max8, D[i] - C[i] - i);

            min1 = Math.min(min1, A[i] + B[i] + i);
            min2 = Math.min(min2, A[i] + B[i] - i);
            min3 = Math.min(min3, A[i] - B[i] + i);
            min4 = Math.min(min4, B[i] - A[i] - i);

            min5 = Math.min(min5, C[i] + D[i] + i);
            min6 = Math.min(min6, C[i] + D[i] - i);
            min7 = Math.min(min7, C[i] - D[i] + i);
            min8 = Math.min(min8, D[i] - C[i] - i);
        }
        System.out.println(max1 + " " + max2 + " " + max3 + " " + max4 + " " + max5 + " " + max6 + " " + max7 + " " + max8);
        System.out.println("min");
        System.out.println(min1 + " " + min2 + " " + min3 + " " + min4 + " " + min5 + " " + min6 + " " + min7 + " " + min8);

        int res = Integer.MIN_VALUE;
        res = Math.max(res, max1 - min1);
        res = Math.max(res, max2 - min2);
        res = Math.max(res, max3 - min3);
        res = Math.max(res, max4 - min4);
        res = Math.max(res, max5 - min5);
        res = Math.max(res, max6 - min6);
        res = Math.max(res, max7 - min7);
        res = Math.max(res, max8 - min8);
        return res;
    }

    public static int getSolveProvidedByTA(int[] A, int[] B, int[] C, int[] D) {
        int[][] max_min = new int[16][2];
        for (int i = 0; i < 16; i++) {
            max_min[i][0] = Integer.MIN_VALUE;
            max_min[i][1] = Integer.MAX_VALUE;
        }
        int N = A.length;
        for (int i = 0; i < N; i++) {
            // note: trick is how to handle four arrays
            for (int j = 0; j < 8; j++) {
                int t = find(A[i], B[i], C[i], D[i], j);
                max_min[j * 2][0] = Integer.max(max_min[j * 2][0], t + i);
                max_min[j * 2][1] = Integer.min(max_min[j * 2][1], t + i);
                max_min[j * 2 + 1][0] = Integer.max(max_min[j * 2 + 1][0], t - i);
                max_min[j * 2 + 1][1] = Integer.min(max_min[j * 2 + 1][1], t - i);
            }
        }
        System.out.print(Arrays.deepToString(max_min));
        int max_abs = Integer.MIN_VALUE;
        for (int i = 0; i < 16; i ++) {
            max_abs = Integer.max(max_abs, max_min[i][0] - max_min[i][1]);
        }

        return max_abs;
    }

    private static int find(int a, int b, int c, int d, int k) {
        int s = a;
        s += ((k & 1) == 0 ? 1 : -1) * b;
        s += ((k & 2) == 0 ? 1 : -1) * c;
        s += ((k & 4) == 0 ? 1 : -1) * d;
        return s;
    }
}

