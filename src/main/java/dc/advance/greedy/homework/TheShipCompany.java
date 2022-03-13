package dc.advance.greedy.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class TheShipCompany {

    public static void main(String[] args) {
        System.out.println(theShipCompany(4, 3, new ArrayList<>(Arrays.asList(2, 1, 1))));
        System.out.println(theShipCompany(4, 3, new ArrayList<>(Arrays.asList(2, 2, 2))));
    }

    public static ArrayList<Integer> theShipCompany(int A, int B, ArrayList<Integer> C) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(C);
        maxHeap.addAll(C);

        int i = 0;
        int max = 0;
        while (i < A && !maxHeap.isEmpty()) {
            int val = maxHeap.poll();
            max += val;
            if ((val - 1) > 0) {
                maxHeap.add(val - 1);
            }
            i++;
        }
        i = 0;
        int min = 0;
        while (i < A && !minHeap.isEmpty()) {
            int val = minHeap.poll();
            min += val;
            if ((val - 1) > 0) {
                minHeap.add(val - 1);
            }
            i++;
        }
        return new ArrayList<>(Arrays.asList(max, min));
    }
}
