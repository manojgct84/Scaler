package dc.advance.Searching2.reversion.assignment;

public class SpecialInteger {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 2, 3, 4, 5}, 10));
        System.out.println(getSolve(new int[]{5, 17, 100, 11}, 130));
    }

    public static int getSolve(int[] A, int B) {
        int res = 0;
        int l = 0;
        int r = A.length;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (check(mid, A, B)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private static boolean check(int mid, int[] a, int b) {
        int sum = 0;
        for (int i = 0; i < mid; i++) {
            sum += a[i];
        }
        if (sum > b) {
            return false;
        }
        for (int i = mid; i < a.length; i++) {
            sum += a[i] - a[i - mid];
            if (sum > b) {
                return false;
            }
        }
        return true;
    }
}
