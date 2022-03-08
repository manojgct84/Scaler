package dc.advance.Heaps.class2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SpecialMedian {

    public static void main(String[] args) {
        System.out.println(specialMedian(new ArrayList<>(Arrays.asList(4, 6, 8, 4))));
        System.out.println(specialMedian(new ArrayList<>(Arrays.asList(2, 7, 3, 1))));
    }

    public static int specialMedian(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        maxHeap.add(A.get(0));
        int median = maxHeap.peek();
        for (int i = 1; i < A.size(); i++) {
            if (median == A.get(i)) {
                return 1;
            }
            if (!maxHeap.isEmpty() && A.get(i) < median) {
                maxHeap.add(A.get(i));
            } else {
                minHeap.add(A.get(i));
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() == minHeap.size()) {
                median = (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                median = maxHeap.peek();
            }
        }

        maxHeap.removeAll(maxHeap);
        minHeap.removeAll(minHeap);

        maxHeap.add(A.get(A.size() - 1));
        median = maxHeap.peek();
        for (int i = A.size() - 2; i >= 0; i--) {
            if (median == A.get(i)) {
                return 1;
            }
            if (!maxHeap.isEmpty() && A.get(i) < median) {
                maxHeap.add(A.get(i));
            } else {
                minHeap.add(A.get(i));
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() == minHeap.size()) {
                median = (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                median = maxHeap.peek();
            }
        }
        return  0;
    }
}
