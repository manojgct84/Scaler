package dc.advance.Heaps.class1.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ProductOf3 {

    public static void main(String[] args) {
        System.out.print(productOf3(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
        System.out.print(productOf3(new ArrayList<>(Arrays.asList(10, 2, 13, 4))));
    }

    public static ArrayList<Integer> productOf3(ArrayList<Integer> A) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        ArrayList<Integer> res = new ArrayList<>();

        int p1 = 1;
        int p2 = 1;
        int p3 = 1;

        for (int i = 0; i < A.size(); i++) {
            heap.add(A.get(i));
            if (i < 2) {
                res.add(-1);
                continue;
            }

            if (!heap.isEmpty()) {
                p1 = heap.poll();
            }
            if (!heap.isEmpty()) {
                p2 = heap.poll();
            }
            if (!heap.isEmpty()) {
                p3 = heap.poll();
            }

            heap.add(p1);
            heap.add(p2);
            heap.add(p3);

            res.add(p1 * p2 * p3);
        }
        return res;
    }
}
