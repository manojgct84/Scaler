package dc.advance.Searching2.assignment;

public class AthMagicalNumber {

    public static void main(String[] args) {
        System.out.println(getSolve(1, 2, 3));
        System.out.println(getSolve(4, 2, 3));
    }

    public static int gcd(int A, int B) {
        if (B <= 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    static int mod = 1000000007;

    public static int getSolve(int A, int B, int C) {
        long value = lcm(B, C);
        long l = Math.min(B, C);
        long r = (long) A * Math.min(B, C);
        int res = 0;
        while (l <= r) {
            long mid = l + ((r - l) >> 1);
            long t = (mid / B + mid / C) - (mid / value);
            if (t >= A) {
                res = (int) (mid % mod);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }


    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
