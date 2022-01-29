package dc.advance.Searching.reversion.assignment;

public class SortedInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public static int searchInsert(int[] A, int B) {
        if (A.length == 0 && B > 0) {
            return 0;
        }
        int l = 0;
        int r = A.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);

            if (A[mid] == B || (mid == 0 && B < A[mid]) || (mid > 0 && B < A[mid] && B > A[mid - 1])) {
                return mid;
            }
            if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return A.length;
    }
}
