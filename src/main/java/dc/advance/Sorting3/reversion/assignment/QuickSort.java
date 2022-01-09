package dc.advance.Sorting3.reversion.assignment;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1, 4, 10, 2, 1, 5})));
        System.out.println(Arrays.toString(solve(new int[]{3, 7, 1})));
    }

    public static int[] solve(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A;
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l > r) {
            return;
        }
        int pivotIndex = reArrange(a, l, r);
        quickSort(a, l, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, r);
    }

    private static int reArrange(int[] a, int l, int r) {
        int p1 = l + 1; //pivot is "l"
        int p2 = r;

        while (p1 <= p2) {
            if (a[p1] < a[l]) {
                p1++;
            } else if (a[p2] > a[l]) {
                p2--;
            } else {
                swap(a, p1, p2);
                p1++;
                p2--;
            }
        }
        swap(a, l, p2); //swap the pivot value in the correct location.
        return p2;// or p1 - 1  - the p1 and p2 will cross over.
    }

    private static void swap(int[] a, int p1, int p2) {
        int temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }
}
