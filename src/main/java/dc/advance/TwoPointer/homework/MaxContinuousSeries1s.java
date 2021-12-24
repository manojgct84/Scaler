package dc.advance.TwoPointer.homework;

import java.util.Arrays;

public class MaxContinuousSeries1s {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxOne(new int[]{1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1}, 3)));
        System.out.println(Arrays.toString(maxOne(new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1}, 1)));
        System.out.println(Arrays.toString(maxOne(new int[]{1, 0, 0, 0, 1, 0, 1}, 2)));
        System.out.println(Arrays.toString(maxOne(new int[]{0, 1, 1, 1}, 0)));
    }

    public static int[] maxOne(int[] A, int B) {

        int i = 0;
        int j = 0;
        int zeros = 0;
        int max = Integer.MIN_VALUE;
        int previous = Integer.MIN_VALUE;
        int low = 0;
        int high = 0;
        //sliding window.
        while (j < A.length) {
            if (A[j] == 1) {
                j++;
            } else if (A[j] == 0) {
                j++;
                zeros++;
            }
            //Once zero is greater than B then move the left pointer  B =3 once zeros is 4.
            if (zeros > B) {
                while (zeros > B) {
                    if (A[i] == 0) {
                        zeros--;
                    }
                    i++;
                }
            }
            max = Math.max(max, (j - i + 1));
            //Maintain the max value index.
            if (max != previous) {
                low = i;
                high = j;
                previous = max;
            }

        }
        int[] res = new int[max - 1];
        for (int k = low; k < high; k++) {
            res[k - low] = k;

        }
        return res;

    }
}
