package dc.advance.gcd.Homework;

public class LargestCoprimeDivisor {

    public static void main(String[] args) {
        System.out.println(getSolved(30, 12));
    }

    public static int getSolved(int A, int B) {
        if (A == 1) {
            return A;
        }

        //remove the value on a continue iterations through GCD
        /**
         * A = 30 == 2 * 3 * 5   - remove the common fact and return the A.
         * B = 12 = 3 * 2 * 3
         */

        while (gcd(A, B) != 1) {
            int val = gcd(A, B);
            if (val > 0) {
                A = A / val;
                System.out.println("A" + A);
            }
            if (val == 0) {
                break;
            }
        }
        return A;
    }

    private static int gcd(int a, int b) {
        System.out.println("a " + a + " b " + b);
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("gcd " + a);
        return a;
    }

}
