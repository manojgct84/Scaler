package dc.advance.Sorting1.homework;

import java.util.Arrays;

public class ReversePairs {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 3, 2, 3, 1}));
        System.out.println(getSolve(new int[]{4, 2, 1}));
    }

    public static int getSolve(int[] A) {

        if (A.length == 1) {
            return 0;
        }
        int[] res = new int[1];
        int count = merge(A, 0, A.length - 1, res);
        //System.out.println(Arrays.toString(A));
        return (res[0] % mod);
    }

    static int mod = (1000000007);

    private static int merge(int[] a, int start, int end, int[] res) {
        if (end == start) {
            return 0;
        }

        int mid = start + end >> 1;

        merge(a, start, mid ,res);
        merge(a, mid + 1, end, res);
        mergeSort(a, start, mid, end, res);
        return (res[0] % mod);
    }

    private static void mergeSort(int[] a, int start, int mid, int end, int[] res) {

        int[] leftArr = Arrays.copyOfRange(a, start, mid + 1);
        int[] rightArr = Arrays.copyOfRange(a, mid + 1, end + 1);

        int i = 0;
        int j = 0;
        int k = 0;
        int[] temp = new int[leftArr.length + rightArr.length];

        System.out.println(Arrays.toString(leftArr));
        System.out.println(Arrays.toString(rightArr));

        int count = 0;
        int left = start, right = mid + 1;
        while (left <= mid) {
            if (right <= end && (a[left] > 2 * (long) a[right])) {
                count = (count + 1) % mod;
                ++right;
            } else {
                res[0] +=count;
                ++left;
            }
        }

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j])
                temp[k++] = leftArr[i++];
            else {
                temp[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            temp[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            temp[k++] = rightArr[j++];
        }

        for (int inx = 0; inx < temp.length; inx++) {
            a[start + inx] = temp[inx];
        }
    }
}
