package dc.advance.Searching.assignment;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        //  System.out.println(getSearch(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 4));
        System.out.println(getMySearch(new int[]{50, 60, 100, 3, 9, 10, 25, 30, 35}, 25));
    }

    public static int getSearch(final int[] A, int B) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (A[mid] == B) {
                return mid;
            }
            if (B < A[0]) {
                if (A[mid] >= A[0]) {
                    start = mid + 1;
                } else {
                    if (B > A[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            } else {
                if (A[mid] < A[0]) {
                    end = mid - 1;
                } else {
                    if (B > A[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static int getSearchRecursion(final int[] A, int B) {

        return binarySearch(A, B, 0, A.length - 1);
    }

    private static int binarySearch(int[] a, int b, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (b == a[mid]) {
            return mid;
        }

        if (a[start] <= a[mid]) {
            if (b >= a[start] && b <= a[mid]) {
                binarySearch(a, b, start, mid - 1);
            } else {
                binarySearch(a, b, mid + 1, end);
            }
        } else {
            if (b >= a[mid] && b <= a[end]) {
                binarySearch(a, b, mid + 1, end);
            } else
                binarySearch(a, b, start, mid - 1);
        }
        return -1;
    }


    public static int getMySearch(final int[] A, int B) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (A[mid] == B) {
                return mid;
            }
            //{50, 60, 100, 3, 9, 10, 25, 30, 35}, 25 - mid = [9]
            if (A[start] <= A[mid]) {
                if (B >= A[start] && B <= A[mid]) { // it is in the P1 part rotated array.
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // {9, 10, 25, 30, 35} - mid is 9. and B = 25
                if (B >= A[mid] && B <= A[end]) { // it is in the p2 part (non-rotated) array
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}