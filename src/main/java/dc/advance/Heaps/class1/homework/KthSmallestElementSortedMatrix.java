package dc.advance.Heaps.class1.homework;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

    public static void main(String[] args) {
        System.out.println(kthSmallestElementSortedMatrix(new int[][]{
                {9, 11, 15},
                {10, 15, 17}}, 6));
        System.out.println(kthSmallestElementSortedMatrix(new int[][]{
                {5, 9, 11},
                {9, 11, 13},
                {10, 12, 15},
                {13, 14, 16},
                {16, 20, 21}}, 12));
    }

    public static int kthSmallestElementSortedMatrix(int[][] A, int B) {
        int n = A[0].length;
        int m = A.length;

        if (B == (m * n)) {
            return A[m - 1][n - 1];
        }

        if (B > (m * n)) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int j = 0;
        int i = 0;
        while (i < A.length) {
            j = 0;
            while (j < A[0].length) {
                minHeap.add(A[i][j]);
                j++;
            }
            i++;
        }
        for (int k = 0; k < B; k++) {
            if (k == B - 1) {
                return minHeap.poll();
            }
            minHeap.poll();
        }
        return 0;
    }
}
