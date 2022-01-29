package dc.advance.Searching2.reversion.assignment;


public class AthMagicalNumber {
    public static void main(String[] args) {
        System.out.println(getSolve(1, 2, 3));
        System.out.println(getSolve(4, 2, 3));
    }

    public static int getSolve(int A, int B, int C) {
        int mod = 1000000007;
        long lcm = getLCM(B, C);
        long l = Math.min(B, C);
        long r = (long) A * Math.min(B, C);
        int res = 0;
        while (l <= r) {
            long mid = l + ((r - l) >> 1);
            long target = (mid / B + mid / C) - (mid / lcm);
            if (target >= A) {
                res = (int) (mid % mod);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;

    }

    private static long getLCM(int b, int c) {
        return (b * c) / gcd(b, c);
    }

    private static int gcd(int b, int c) {
        if (c <= 0) {
            return b;
        }
        return gcd(c, b % c);
    }
}
