package dc.advance.Heaps.class2.assignment;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KPlacesApart {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kPlacesApart(new int[]{1, 40, 2, 3}, 2)));
        System.out.println(Arrays.toString(kPlacesApart(new int[]{2, 1, 17, 10, 21, 95}, 1)));
    }

    public static int[] kPlacesApart(int[] A, int B) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;
        while (i <= B) {
            minHeap.add(A[i]);
            i++;
        }
        int[] res = new int[A.length];
        int j = 0;
        while (i < A.length) {
            res[j] = minHeap.poll();
            minHeap.add(A[i]);
            j++;
            i++;
        }
        while (!minHeap.isEmpty()) {
            res[j] = minHeap.poll();
            j++;
        }

        return res;
    }
}
