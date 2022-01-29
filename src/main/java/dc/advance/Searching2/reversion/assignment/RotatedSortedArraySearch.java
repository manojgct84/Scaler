package dc.advance.Searching2.reversion.assignment;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        System.out.println(getSearch(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 4));
        System.out.println(getSearch(new int[]{50, 60, 100, 3, 9, 10, 25, 30, 35}, 25));
    }

    public static int getSearch(final int[] A, int B) {
        int index = findRotation(A);
        if (B >= A[0]) {
            return binarySearch(0, index - 1, A, B);
        }
        return binarySearch(index, A.length - 1, A, B);
    }

    private static int binarySearch(int l, int r, int[] a, int target) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target == a[mid]) {
                return mid;
            }
            if (target < a[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private static int findRotation(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (!(a[i] > a[i - 1])) {
               // System.out.println("rotation index " + i);
                return i;
            }
        }
        return -1;
    }
}
