package dc.advance.Heaps.class2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumLargestElement {

    public static void main(String[] args) {
        System.out.println(minimumLargestElement(new ArrayList<>(Arrays.asList(1, 2, 3, 4)), 3));
        System.out.println(minimumLargestElement(new ArrayList<>(Arrays.asList(5, 1, 4, 2)), 5));
    }

    public static int minimumLargestElement(ArrayList<Integer> A, int B) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.number >= o2.number ? 1 : -1;
            }
        });

        ArrayList<Integer> state = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            state.add(A.get(i));
            minHeap.add(new Pair(2 * A.get(i), i));
        }

        while (B > 0) {
            Pair pair = minHeap.poll();
            if (pair != null) {
                int val = A.get(pair.index);
                int curr = state.get(pair.index);
                state.set(pair.index, curr + val);
                minHeap.add(new Pair(val + pair.number, pair.index));
            }
            B--;
        }

        System.out.print(" " + state.toString());
        int max = state.get(0);

        for (int i = 1; i < state.size(); i++) {
            max = Math.max(max, state.get(i));
        }
        return max;
    }

    static class Pair {
        int number;
        int index;

        Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }
}
