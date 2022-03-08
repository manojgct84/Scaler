package dc.advance.Heaps.class2.assignment;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * for i <= 3 output should be -1.
 * for i = 4 , Subarray [1:4] has 4 elements 1, 2, 3 and 4. So, 4th maximum element is 1.
 * for i = 5 , Subarray [1:5] has 5 elements 1, 2, 3, 4 and 5. So, 4th maximum element is 2.
 * for i = 6 , Subarray [1:6] has 6 elements 1, 2, 3, 4, 5 and 6. So, 4th maximum element is 3.
 * So, output array is [-1, -1, -1, 1, 2, 3].
 */
public class AthLargestElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(athLargestElement(4, new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(athLargestElement(2, new int[]{15, 20, 99, 1})));
    }

    public static int[] athLargestElement(int A, int[] B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] res = new int[B.length];
        int i = 0;
        while (i < A) {
            if (i < A - 1) {
                res[i] = -1;
            }
            minHeap.add(B[i]);
            i++;
        }
        res[A - 1] = minHeap.peek();
        while (i < B.length) {
            minHeap.add(B[i]);
            minHeap.poll();
            res[i] = minHeap.peek();
            i++;
        }
        return res;
    }
}
