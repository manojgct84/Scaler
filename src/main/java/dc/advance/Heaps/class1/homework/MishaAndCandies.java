package dc.advance.Heaps.class1.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MishaAndCandies {

    public static void main(String[] args) {
        System.out.println(mishaAndCandies(new ArrayList<>(Arrays.asList(3, 2, 3)), 4));
        System.out.println(mishaAndCandies(new ArrayList<>(Arrays.asList(1, 2, 1)), 2));
    }

    public static int mishaAndCandies(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(A);
        int maxCandy = 0;
        if (minheap.size() == 1 && minheap.peek() <= B) {
            return minheap.poll() / 2;
        }
        while (!minheap.isEmpty()) {
            if (minheap.peek() > B) {
                return maxCandy;
            }
            int candy = minheap.poll();
            if (candy <= B) {
                maxCandy += (int) Math.floor(candy / 2);
            } else {
                break;
            }
             if (!minheap.isEmpty()) {
                 minheap.add(minheap.poll() + (candy - candy / 2));
            }
        }
        return maxCandy;
    }
}
