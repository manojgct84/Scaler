package dc.advance.resursion.reversion.recursion1.homework;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println(getSolve(46));
        System.out.println(getSolve(11));
    }

    public static int getSolve(int A) {
        if (A < 9) {
            return A;
        }
        return A % 10 + getSolve(A / 10);
    }
}
