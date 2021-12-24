package dc.advance.resursion.reversion.recursion1.assignment;

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
