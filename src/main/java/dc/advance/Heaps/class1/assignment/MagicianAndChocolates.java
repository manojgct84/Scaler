package dc.advance.Heaps.class1.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public static void main(String[] args) {
        System.out.println(nchoc(3, new ArrayList<>(Arrays.asList(6, 5))));
        System.out.println(nchoc(5, new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10))));
    }

    public static int nchoc(int A, ArrayList<Integer> B) {

        if (B.size() == 0) {
            return 0;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(B);

        long res = 0;
        int mod = 1000000007;

        for (int i = A; i > 0; i--) {
            int max = heap.poll();
            res += (max % mod);
            heap.add((int) Math.floor(max / 2));
        }
        return (int) (res % mod);
    }
}
