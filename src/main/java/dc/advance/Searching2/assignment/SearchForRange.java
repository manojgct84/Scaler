package dc.advance.Searching2.assignment;

import java.util.Arrays;

public class SearchForRange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 17, 100, 111}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6,
                6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
                7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 10)));
        System.out.println(Arrays.toString(searchRange(new int[]{4, 7, 7, 7, 8, 10, 10}, 3)));
    }

    public static int[] searchRange(final int[] A, int B) {
        int[] res = new int[2];
        int first = firstIndex(A, B);
        if (first != -1)
            res[0] = first;
        else
            res[0] = -1;
        //left index is used as the starting index [left index].
        int sec = secondIndex(A, first, B);
        if (sec != -1)
            res[1] = sec;
        else
            res[1] = -1;

        return res;
    }

    private static int secondIndex(int[] a, int l, int b) {
        int r = a.length - 1;
        int sec = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 2);

            if (mid > 0 && a[mid] == b) {
                sec = mid;     // Always store the index as you find still you reach las index.
                l = mid + 1;   // Always move right as you find target
            } else if (mid < 0) {
                return -1;
            }

            if (a[mid] <= b) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return sec;
    }

    private static int firstIndex(int[] a, int b) {

        int l = 0;
        int r = a.length - 1;
        int first = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            /*if ((mid == 0 || a[mid] != a[mid - 1]) && (a[mid] == b)) {
                return mid;
            }*/
            if (mid >= 0 && a[mid] == b) {
                first = mid; //Always store the index as you find still you reach las index.
                r = mid - 1; // Always move left as you find target
            }
            if (a[mid] <= b) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return first;
    }
}
