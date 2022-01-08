package dc.mock.interview;

//https://leetcode.com/problems/happy-number

import dc.advance.resursion.reversion.recursion1.assignment.IsMagic;
import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
//https://www.educative.io/edpresso/how-to-solve-the-happy-number-problem-in-java

/**
 * T[N] =  n/2 + T(n/10)
 * T[n/10] = n/4 + T[n/10]
 * T[n]  = n/2^k + T[n/k]
 * n/2^k = 0
 * n = 2^k
 * log k = n
 * n/k = 0 // base condition
 * n = k
 * T[n] = log k + T(k/k)
 * <p>
 * T[n] = log k
 */

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new HappyNumber().solveSet(83557));
        System.out.println(new HappyNumber().solveSet(1291));
        System.out.println(new HappyNumber().solveSet(19));
        System.out.println(new HappyNumber().solveSet(2));
        System.out.println(new HappyNumber().solveSet(3));
        System.out.println(new HappyNumber().solveSet(4));
        System.out.println(new HappyNumber().solveSet(5));
        System.out.println(new HappyNumber().solveSet(6));
        System.out.println(new HappyNumber().solveSet(7));
        System.out.println(new HappyNumber().solveSet(8));
        System.out.println(new HappyNumber().solveSet(9));
        System.out.println(new HappyNumber().solveSet(10));
        System.out.println(new HappyNumber().solveSet(1234567349));
        System.out.println(new HappyNumber().solveSet(19));
        System.out.println(new HappyNumber().solveSet(33));
        System.out.println(new HappyNumber().solveSet(16));
    }

    private boolean solve(int A) {
        int input = A;
        while (A > 9) {
            A = sumSqrtDigits(A);
            System.out.println(A);
        }
        System.out.println(" Input " + input + " Output " + A);
        return A == 1;
    }

    public static int sumSqrtDigits(int A) {
        if (A == 0) {
            return 0;
        }

        return (int) Math.pow((A % 10), 2) + sumSqrtDigits(A / 10);
    }

    //This is using the set data Structure to check if the value is present.
    private boolean solveSet(int A) {
        int input = A;
        Set<Integer> set = new HashSet<>();
        while (A != 1) {
            A = sumDigitsPow(A);
            if (!set.contains(A)) {
                set.add(A);
            } else if (set.contains(A)) {
                break;
            }
        }
        System.out.println(" Input " + input + " Output " + A);
        return A == 1;
    }

    public static int sumDigitsPow(int A) {
        int sum = 0;
        while (A != 0) {
            int a = A % 10;
            int pow = (int) Math.pow(a, 2);
            sum += pow;
            A /= 10;
        }
        return sum;
    }
}
