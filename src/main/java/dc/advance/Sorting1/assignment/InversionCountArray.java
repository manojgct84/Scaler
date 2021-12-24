package dc.advance.Sorting1.assignment;

import java.util.Arrays;

public class InversionCountArray {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{3, 2, 1}));
        System.out.println(getSolve(new int[]{5, 6, 3, 4, 1, 2}));
        System.out.println(getSolve(new int[]{7, 8, 9, 2, 3, 1, 4,}));
    }

    public static int getSolve(int[] A) {

        if (A.length < 1) {
            return 1;
        }

        int count =  split(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
        return count;
    }

    private static int split(int[] a, int start, int end) {
        int count = 0;
        if (end == start) {
            return 0;
        }

        int mid = (start + end) >> 1;
        count += split(a, start, mid);
        count += split(a, mid + 1, end);
        count += merge(a, start, mid, end);
        return count;
    }
    static int  mod = (1000000007);
    private static int merge(int[] a, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] aux = new int[end - start + 1];
        int k = 0;
        int count = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                aux[k++] = a[i];
                i++;
            } else {
                count = (count + (mid - i) + 1) % mod;
                aux[k++] = a[j];
                j++;
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
        //  System.out.println(Arrays.toString(a));
        return count;
    }
}
