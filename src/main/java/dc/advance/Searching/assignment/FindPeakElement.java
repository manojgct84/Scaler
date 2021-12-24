package dc.advance.Searching.assignment;

public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 2, 3, 4, 5}));
        System.out.println(getSolve(new int[]{5, 17, 100, 11}));
        System.out.println(getSolve(new int[]{3, 2}));
    }

    public static int getSolve(int[] A) {

        if (A.length == 1) {
            return A[0];
        }
        int start = 0;
        int end = A.length;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (mid == A.length - 1) {
                return Math.max(A[mid], A[mid - 1]);
            } else if (mid == 0) {
                return Math.max(A[mid], A[mid + 1]);
            }
            // mid > previous element  and mid > next element that is the answer
            if (mid > 0 && (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1])) {
                return A[mid];
            // previous element > mid and mid > next element move [left] in the array.
            } else if (mid > 0 && A[mid - 1] >= A[mid] && A[mid] > A[mid + 1]) {
                end = mid - 1;
            // previous element < mid and mid < next element move [right] in the array.
            } else if (mid > 0 && A[mid - 1] < A[mid] && A[mid] <= A[mid + 1]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
