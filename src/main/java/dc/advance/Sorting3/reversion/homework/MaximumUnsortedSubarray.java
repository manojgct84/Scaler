package dc.advance.Sorting3.reversion.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumUnsortedSubarray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(subUnsort(new int[]{1, 3, 2, 4, 5})));
        System.out.println(Arrays.toString(subUnsort(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] subUnsort(int[] A) {
        int[] org = new int[A.length];
        System.arraycopy(A, 0, org, 0, A.length);
        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                index++;
            } else {
                break;
            }
        }
        if (index == A.length) {
            return new int[]{-1};
        }
        List<Integer> res = new ArrayList<>();
        mergeSort(org, 0, A.length - 1);
        int i = 0;
        int j = 0;
        while (i < A.length && j < org.length) {
            if (A[i] != org[j]) {
                res.add(i);
            }
            i++;
            j++;
        }
        if (res.size() > 0) {
            return new int[] {res.get(0), res.get(res.size() - 1)};
        }
        return new int[]{-1};
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        mergeValue(a, start, mid, end);
    }

    private static void mergeValue(int[] a, int start, int mid, int end) {
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
