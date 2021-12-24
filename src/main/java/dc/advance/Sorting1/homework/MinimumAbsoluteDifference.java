package dc.advance.Sorting1.homework;

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{5, 17, 100, 11}));
        System.out.println(solve(new int[]{1, 2, 3, 4, 5}));
    }

    public static int solve(int[] A) {

        if (A.length == 1) {
            return A[0];
        }

        mergeSortRecursion(A, 0, A.length - 1);
      //  System.out.println(Arrays.toString(A));
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            diff = Math.min(diff, A[i] - A[i - 1]);
        }
        return diff;
    }

    private static void mergeSortRecursion(int[] a, int start, int end) {

        if (end == start) {
            return;
        }

        int mid = start + end >> 1;

        mergeSortRecursion(a, start, mid);
        mergeSortRecursion(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] aux = new int[end - start + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
        }

        while (i <= mid) {
            aux[k++] = a[i++];
        }
        while (j <= end) {
            aux[k++] = a[j++];
        }

        for (int index = 0; index < aux.length; index++) {
            a[start + index] = aux[index];
        }
    }
}
