package dc.advance.resursion.reversion.recursion1.assignment;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(solve(46));
        System.out.println(solve(11));
    }

    public static int solve(int A) {
        if (A < 9) {
            return A;
        }
        return A % 10 + solve(A / 10);
    }
}
