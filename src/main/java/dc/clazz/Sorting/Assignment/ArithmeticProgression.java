package dc.clazz.Sorting.Assignment;

import java.util.Arrays;

public class ArithmeticProgression {
    public static void main(String[] args) {
        //System.out.println((getSolution(new int[]{-251, -305, -323, -53, -215, -143, -107, -161, -179, -431, -449, -17, -341, -413, -35, -125, -197, -377, -269, -71, -359, -89, -233, -287, -395})));
        System.out.println((getSolution(new int[]{2, 4, 1})));
    }

    private static int getSolution(int[] A) {

        if (A.length == 0 || A.length == 1) {
            return 0;
        }

        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int i = 0;
        int j = A.length - 1;
        //1,2,4
        int diff = (A[i + 1] - A[0]);
        int nDiff = (A[j - 1] - A[j]);
        System.out.println(diff + " " + nDiff);
        while (i < A.length - 1 && j >= 1) {

            if (!(A[i + 1] - A[i] == diff)) {
                System.out.println(i);
                return 0;
            }

            if (!(A[j - 1] - A[j] == nDiff)) {
                System.out.println(j);
                return 0;
            }

            i++;
            j--;
        }
        return 1;
    }
}
