package dc.advance.bitManipulation.reversion.assignment2.homework;

public class DivideIntegers {

    public static void main(String[] args) {
        System.out.println(divide(5, 2));
        System.out.println(divide(-5, 2));
    }

    public static int divide(int A, int B) {

        if (Math.abs((long) A) >= Integer.MAX_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }

        if (Math.abs((long) A) >= Integer.MAX_VALUE && B == 1) {
            return A;
        }

        long a = A;
        long b = B;

        if (A < 0) {
            a = (-1 * a);
        }
        if (B < 0) {
            b = (-1 * b);
        }

        long temp = 0;
        long res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((temp + (b << i)) <= a) {
                temp += (b << i);
                res = res | (1 << i); //This is to set the ith bit in the res.
            }
        }
        return (int) (((A >= 0 && B >= 0) || (A < 0 && B < 0)) ? res : -res);
    }
}
