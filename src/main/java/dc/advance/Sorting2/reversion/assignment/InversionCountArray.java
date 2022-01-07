package dc.advance.Sorting2.reversion.assignment;

public class InversionCountArray {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 2, 1}));
        System.out.println(solve(new int[]{1, 2, 3}));
    }

    public static int solve(int[] A) {
        return inversionMergeSort(A, 0, A.length - 1);
    }

    static int mod = (1000000007);

    private static int inversionMergeSort(int[] a, int start, int end) {

        if (end == start) {
            return 0;
        }
        int mid = start + ((end - start) >> 1);
        int x = inversionMergeSort(a, start, mid);
        int y = inversionMergeSort(a, mid + 1, end);
        int z = mergeArray(a, start, mid, end);
        return (x + y + z) % mod;
    }

    private static int mergeArray(int[] a, int start, int mid, int end) {
        int[] aux = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int count = 0;
        int k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                aux[k++] = a[i++];
            } else {
                count = count + ((mid - i) + 1) % mod;
                aux[k++] = a[j++];
            }
        }
        if (i != mid) {
            while (i < mid) {
                aux[k++] = a[i++];
            }
        }

        if (j != end) {
            while (j < end) {
                aux[k++] = a[j++];
            }
        }

        for (int x = 0; x < aux.length; x++) {
            a[start + x] = a[x];
        }
        return count % mod;
    }
}
