package dc.advance.TwoPointer.reversion.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.text.MutableAttributeSet;

/**
 * Problem Description
 * <p>
 * Given an array A of N integers, find three integers in A such that the sum is closest to a given
 * number B. Return the sum of those three integers.
 * <p>
 * Assume that there will only be one solution.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * -108 <= B <= 108
 * 1 <= N <= 104
 * -108 <= A[i] <= 108
 */
public class Sum3 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(-1, 2, 1, -4)), 2));
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(1, 2, 3)), 6));
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(-10, -10, -10)), -5));
    }

    public static int threeSumClosest(ArrayList<Integer> A, int B) {
        int i = 0;
        Collections.sort(A);
        long closestSum = Integer.MAX_VALUE;
        while (i < A.size()) {
            int j = i + 1;
            int k = A.size() - 1;
            int sum = A.get(i);
            while (j < k) {
                sum += A.get(j) + A.get(k);
                if (Math.abs(sum - B) <  Math.abs(closestSum - B)) {
                    closestSum = sum;
                } else {
                    if (sum < B) {
                        j++;
                    } else {
                        k--;
                    }
                }
                sum = A.get(i);
            }
            i++;
        }
        return (int) closestSum;
    }
}
