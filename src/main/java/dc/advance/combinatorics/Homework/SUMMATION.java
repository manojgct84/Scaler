package dc.advance.combinatorics.Homework;

public class SUMMATION {

    public static void main(String[] args) {
        System.out.println(getSolve(3));
    }

    static int mod = 1000000007;

    public static int getSolve(int A) {
        long res = ((long) A * (long) (A - 1)) % mod * (long) fastPowerFunction(3, (A - 2));
        return (int) (res % mod);
    }

    private static int fastPowerFunction(int pow, int B) {
        //Fast Power Function
        long result = 1;
        long a = pow % mod;
        while (B > 0) {
            if ((B & 1) == 1) {
                result = ((result * a) % mod);
                a = ((a * a) % mod);
                B = (B - 1) >> 1; // (b - 1)/ 2
            } else {
                a = ((a * a) % mod);
                B >>= 1; // b /=2
            }
        }
        return (int) (result % mod);
    }
}
