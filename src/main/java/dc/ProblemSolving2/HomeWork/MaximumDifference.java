package dc.ProblemSolving2.HomeWork;

import java.util.Arrays;

public class MaximumDifference {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1,2,3,4,5}, 2));
    }

    private static int getSolve(int[] A, int B) {

        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        //5,11,17,100
        int leftSum = 0;
        for (int i = 0; i < B; i++) {
            leftSum += A[i];
        }
        //23
        int rightSum = 0;
        for (int i = A.length - 1; i >= (A.length - B); i--) {
            rightSum += A[i];
        }

        System.out.println("left " + leftSum);
        System.out.println("rightSum " + rightSum);

        int max = Integer.MIN_VALUE;
        int rightHalf = 0;
        for (int i = B; i < A.length; i++) {
            rightHalf += A[i];
        }
        System.out.println("rightHalf " + rightHalf);


        max = Math.max(max, (rightHalf - leftSum));
        int leftHalf = 0;
        for (int i = (A.length - 1 - B); i >= 0; i--) {
            leftHalf += A[i];
        }
        System.out.println("leftHalf " + leftHalf);
        max = Math.max(max, (rightSum - leftHalf));

        return max;
 /*      int max = Integer.MIN_VALUE;
         int i = 0;
        while (i < A.length - B) {
            int j = 0;
            while (j < B) {
                s2 += A[i];
                i++;
                j++;
            }
            max = Math.max(max, (s1 - s2));
        }
        return max;*/
    }
}
