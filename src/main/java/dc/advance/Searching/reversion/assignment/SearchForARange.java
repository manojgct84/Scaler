package dc.advance.Searching.reversion.assignment;

import java.util.Arrays;

public class SearchForARange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 17, 100, 111}, 3)));
    }

    public static int[] searchRange(final int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        //   int pos = 0;
        int[] res = {-1, -1};
        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (A[mid] == B) {
                res[0] = mid;
                r = mid - 1;
            } else if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = 0;
        r = A.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (A[mid] == B) {
                res[1] = mid;
                l = mid + 1;
            } else if (A[mid] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
