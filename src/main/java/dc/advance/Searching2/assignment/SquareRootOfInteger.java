package dc.advance.Searching2.assignment;

public class SquareRootOfInteger {

    public static void main(String[] args) {
        System.out.println(sqrt(11));
        System.out.println(sqrt(9));
        System.out.println(sqrt(53));
    }

    public static int sqrt(int A) {
        int l = 1;
        int r = A;
        int res = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int sqrtVal = (mid * mid);
            if (sqrtVal == A) {
                return mid;
            }
            if (mid <= A / mid) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
