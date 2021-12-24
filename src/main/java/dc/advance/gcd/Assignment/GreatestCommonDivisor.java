package dc.advance.gcd.Assignment;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getSolve(4, 6));
    }

    public static int getSolve(int A, int B) {
        while (B > 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
}
