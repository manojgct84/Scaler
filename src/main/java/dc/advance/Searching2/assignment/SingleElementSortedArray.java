package dc.advance.Searching2.assignment;

public class SingleElementSortedArray {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 1, 7}));
        System.out.println(getSolve(new int[]{2, 3, 3}));
        System.out.println(getSolve(new int[]{5, 11, 11, 100, 100}));
        System.out.println(getSolve(new int[]{13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110,
                110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190,
                200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348,
                348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493}));
        System.out.println(getSolve(new int[]{1, 1, 2, 2, 3}));
    }

    public static int getSolve(int[] A) {
        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (mid == 0 || (A[mid] != A[mid - 1]) && (mid == A.length - 1 || A[mid] != A[mid + 1])) {
                return A[mid];
            }

            if (mid == 0 || A[mid] != A[mid - 1]) {
                if (mid % 2 == 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            } else {
                if (mid % 2 == 0) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
