package dc.advance.Sorting3.reversion.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an integer array A of size N.
 * You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.
 * <p>
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 * <p>
 * NOTE: Subsequence can be non-contiguous.
 * <p>
 * <p>
 * All possible non-empty subsets are:
 * [1]    largest-smallest = 1 - 1 = 0
 * [2]    largest-smallest = 2 - 2 = 0
 * [1 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 */
public class SumtheDifference {

    public static void main(String[] args) {
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 2))));
    }

    public static int getSolve(ArrayList<Integer> A) {
        int mod = 1000000007;
        Collections.sort(A);
        int min = 0;
        int max = 0;
        int pow = 2;
        for (int i = 0; i < A.size(); i++) {
            min = (pow * min) + A.get(i);
            max = (pow * max) + A.get(A.size() - i - 1);
        }
        return (max - min) % mod;
    }

}
