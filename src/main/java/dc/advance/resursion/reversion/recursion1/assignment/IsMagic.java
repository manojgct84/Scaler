package dc.advance.resursion.reversion.recursion1.assignment;

//https://leetcode.com/problems/happy-number

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

    
public class IsMagic {

    public static void main(String[] args) {
        System.out.println(new IsMagic().solve(83557));
        System.out.println(new IsMagic().solve(1291));
    }

    public int sumOfDigits(int a) {
        if (a == 0) {
            return 0;
        }
        return a % 10 + sumOfDigits(a / 10);
    }

    public int solve(int A) {
        while (A > 9) {
            A = sumOfDigits(A);
        }
        if (A == 1) {
            return 1;
        }
        return 0;
    }
}
