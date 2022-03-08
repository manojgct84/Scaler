package dc.advance.Heaps.class2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningMedian(new int[]{1, 2, 5, 4, 3})));
        System.out.println(Arrays.toString(runningMedian(new int[]{5, 17, 100, 11})));
    }

    public static int[] runningMedian(int[] A) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        maxHeap.add(A[0]);
        res.add(maxHeap.peek());
        for (int i = 1; i < A.length; i++) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > A[i]) {
                maxHeap.add(A[i]);
            } else {
                minHeap.add(A[i]);
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() >= minHeap.size()) {
                res.add(maxHeap.peek());
            } else {
                res.add(minHeap.peek());
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
