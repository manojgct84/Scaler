package dc.advance.Searching3.Homework;

import java.util.Arrays;

public class FindSmallestAgain {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 5, 7, 3, 2}, 9));
        System.out.println(getSolve(new int[]{2, 4, 3, 2}, 3));
    }

    public static int getSolve(int[] A, int B) {
        Arrays.sort(A);
        int low = A[0] + A[1] + A[2];
        int high = A[A.length - 1] + A[A.length - 2] + A[A.length - 3];
        int res = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (check(A, B, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }


    private static boolean check(int[] a, int b, int mid) {

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int val = mid - (a[i] + a[j]);
                if (val <= 0) {
                    break;
                }
                int idx = Arrays.binarySearch(a, val);
                if (idx > j) {
                    count += (idx - j);
                }
            }
        }
        return (count < b);
    }

}
