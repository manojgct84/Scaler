package dc.clazz.Sorting.Assignment.HomeWork;

import java.util.Arrays;

public class ElementsRemoval {

    public static void main(String[] args) {
        //System.out.println((getSolution(new int[]{-251, -305, -323, -53, -215, -143, -107, -161, -179, -431, -449, -17, -341, -413, -35, -125, -197, -377, -269, -71, -359, -89, -233, -287, -395})));
        //System.out.println((getSolution(new int[]{2, 1})));
        System.out.println((getSolution(new int[]{3,2,1,5})));
    }

    private static int getSolution(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        int sum = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            sum += A[i];
            int j = i - 1;
            while (j >= 0) {
                sum += A[j];
                j--;
            }
        }
        return sum;
    }
}