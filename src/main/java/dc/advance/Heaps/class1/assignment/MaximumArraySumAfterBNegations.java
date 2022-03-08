package dc.advance.Heaps.class1.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumArraySumAfterBNegations {

    public static void main(String[] args) {
        System.out.println(maximumArraySumAfterBNegations(new ArrayList<>(Arrays.asList(24, -68,
                -29, -9, 84)), 4));
        System.out.println(maximumArraySumAfterBNegations(new ArrayList<>(Arrays.asList(57, 3,
                -14, -87, 42, 38, 31, -7, -28, -61)), 10));
    }

    public static int maximumArraySumAfterBNegations(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.addAll(A);
        while (B > 0) {
            int val = heap.poll();
            if (val < 0) {
                heap.add(-(val));
                B--;
            } else {
                heap.add((val));
                break;
            }
        }
        while (B > 0) {
            if (B % 2 != 0 && heap.peek() > 0) {
                int val = heap.poll();
                heap.add(-val);
                B--;
            } else {
                break;
            }
        }
        int res = 0;
        while (!heap.isEmpty()) {
            res += heap.poll();
        }
        return res;
    }
}
