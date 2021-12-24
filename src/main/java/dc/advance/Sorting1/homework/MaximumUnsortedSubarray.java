package dc.advance.Sorting1.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumUnsortedSubarray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(subUnsort(new int[]{1, 3, 2, 4, 5})));
        System.out.println(Arrays.toString(subUnsort(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] subUnsort(int[] A) {
        if (A.length == 1) {
            return new int[]{1};
        }
        int inx = 1;
        while (inx < A.length) {
            if (A[inx - 1] < A[inx]) {
                inx++;
            } else {
                break;
            }
        }
        if (inx == A.length) {
            return new int[]{-1};
        }

        int n = A.length;
        int[] original = new int[n];
        System.arraycopy(A, 0, original, 0, n);
        mergeSort(A, 0, A.length - 1);
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n && j < n) {
            if (A[i] != original[j]) {
                res.add(i);
            }
            i++;
            j++;
        }
        if (res.size() > 0) {
            return new int[]{res.get(0), res.get(res.size() - 1)};
        }
        return new int[]{-1};
    }

    private static void mergeSort(int[] a, int start, int end) {

        if (end == start) {
            return;
        }
        int mid = end + start >> 1;

        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= end) {
            temp[k++] = a[j++];
        }

        for (int inx = 0; inx < temp.length; inx++) {
            a[start + inx] = temp[inx];
        }
    }
}
