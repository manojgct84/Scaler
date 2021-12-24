package dc.advance.bitManipulation.homework;

public class DivideIntegers {

    public static void main(String[] args) {
        //    System.out.println(getSolve(-2147483648, -1));
        //   System.out.println(getSolve(-1, 1));
        System.out.println(getOtherSolve(0, 1));
        System.out.println(getOtherSolve(-2147483648, -10000000));
    }

    public static int getSolve(int A, int B) {

        if (Math.abs((long) A) >= Integer.MAX_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }
        int a = Math.abs(A);
        int b = Math.abs(B);

        long res = 0;
        while (a - b >= 0) {
            int pow = 0;
            while (a - (b * Math.pow(2, 1) * Math.pow(2, pow)) > 0) {
                pow++;
            }
            res += 1 << pow;
            a -= b << pow;
        }
        return (int) ((A >= 0 && B >= 0) || (A < 0 && B < 0) ? res : -res);
    }

    public static int getOtherSolve(int A, int B) {

        if (Math.abs((long) A) >= Integer.MAX_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }
        if (Math.abs((long) A) >= Integer.MAX_VALUE && B == 1) {
            return A;
        }
        long a = Math.abs(A);
        long b = Math.abs(B);

        if (a < 0) {
            a *= -1;
        }
        if (b < 0) {
            b *= -1;
        }
        long res = 0;
        long temp = 0;
        for (int i = 31; i >= 0; i--) {

            if ((temp + (b << i)) <= a) {
                temp += b << i;
                res = res | 1 << i;
            }
        }

        return (int) ((A >= 0 && B >= 0) || (A < 0 && B < 0) ? res : -res);
    }
}
