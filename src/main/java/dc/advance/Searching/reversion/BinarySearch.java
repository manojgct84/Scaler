package dc.advance.Searching.reversion;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySeach(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    private static int binarySeach(int[] A) {
        int k = 6;
        return recursionBinarySearch(A, 0, A.length - 1, k);
    }

    private static int recursionBinarySearch(int[] a, int l, int r, int k) {
        if (l <= r) {
            int mid = l + (r - l >> 1);
            if (a[mid] == k) {
                return mid;
            } else if (a[mid] < k) {
                return recursionBinarySearch(a, mid + 1, r, k);
            } else {
                return recursionBinarySearch(a, l, mid - 1, k);
            }
        }
        return -1;
    }

}
