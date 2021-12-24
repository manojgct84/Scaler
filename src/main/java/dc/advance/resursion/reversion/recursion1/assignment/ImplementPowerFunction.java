package dc.advance.resursion.reversion.recursion1.assignment;

public class ImplementPowerFunction {

    public static void main(String[] args) {
        System.out.println(pow(2, 3, 3));
        System.out.println(pow(-1, 1, 20));
        System.out.println(pow(-1, 2, 20));
    }

    public static int pow(int A, int B, int C) {
        if (A == 0 && B == 0) {
            return 0;
        }

        int res = powerFun(A, B, C);
        if (res < 0) {
            return (res + C) % C;
        }
        return res;
    }

    private static int powerFun(int x, int n, int d) {


        if (n == 0) {
            return 1;
        }

        int res = powerFun(x, (n / 2), d) % d;

        /*BigInteger bigInteger = BigInteger.valueOf(A);
        return bigInteger.modPow(BigInteger.valueOf(B), BigInteger.valueOf(C)).intValue();*/

        if ((n & 1) == 0) {
            return ((res * res) % d) * (n % d) % d;
        } else {
            return (x % d * (res * res) % d) % d;
        }
    }

    public int powEditorial(int x, int n, int d) {

        long a = x;
        long res = 1L;

        while (n > 0) {
            if (n % 2 == 1) {
                res *= a;
                res %= d;
            }
            a *= a;
            a %= d;
            n = n >> 1;
        }
        res = (res + d) % d;
        return (int) res;
    }
}
