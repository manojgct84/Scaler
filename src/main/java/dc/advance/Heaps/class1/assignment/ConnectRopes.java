package dc.advance.Heaps.class1.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectRopes {

    public static void main(String[] args) {
        System.out.print(connectRopes(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
        System.out.print(connectRopes(new ArrayList<>(Arrays.asList(1, 18))));
    }

    public static int connectRopes(ArrayList<Integer> A) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.addAll(A);

        int cost = 0;
        int y = 0;
        int x;
        for (int i = 0; i < A.size(); i++) {
            if (heap.size() != 0) {
                x = heap.poll();
            } else {
                x = 0;
            }
            if (heap.size() != 0) {
                y = heap.poll();
            } else {
                x = 0;
            }
            if (x !=0 && y !=0) {
                cost += (x + y);
                heap.add(x + y);
            }
        }
        return cost;
    }
}
