package dc.mock.interview;

//https://leetcode.com/problems/happy-number

import dc.advance.resursion.reversion.recursion1.assignment.IsMagic;

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

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new HappyNumber().solve(83557));
        System.out.println(new HappyNumber().solve(1291));
        System.out.println(new HappyNumber().solve(19));
       System.out.println(new HappyNumber().solve(2));
        System.out.println(new HappyNumber().solve(3));
        System.out.println(new HappyNumber().solve(4));
        System.out.println(new HappyNumber().solve(5));
        System.out.println(new HappyNumber().solve(6));
        System.out.println(new HappyNumber().solve(7));
        System.out.println(new HappyNumber().solve(8));
        System.out.println(new HappyNumber().solve(9));
        System.out.println(new HappyNumber().solve(10));
        System.out.println(new HappyNumber().solve(1234567349));
    }

    private boolean solve(int A) {
        Integer input = new Integer(A);
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
}
