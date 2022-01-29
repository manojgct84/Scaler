package dc.advance.Searching2.reversion.homework;

public class SearchBitonicArray {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{3, 9, 10, 20, 17, 5, 1}, 20));
        System.out.println(getSolve(new int[]{5, 6, 7, 8, 9, 10, 3, 2, 1}, 30));
        System.out.println(getSolve(new int[]{5, 1, 2, 3, 4}, 3));
    }

    public static int getSolve(int[] A, int B) {
        int index = findBitonic(A);
        return index;
    }

    private static int findBitonic(int[] a) {
        int l = 0;
        int r = a.length;
        int res = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] < a[mid - 1] && a[mid] > a[mid + 1]) {
                res = mid;
                r = mid - 1;
            } else if (a[mid - 1] < a[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
