package dc.clazz.Hash.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HotelOccurrences {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolutionHotelOccurrences(new int[]{1, 2, 3, 2, 5, 3, 2, 4})));
    }

    private static int[] getSolutionHotelOccurrences(int[] A) {
        if (A.length == 1) {
            return A;
        }

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(A.length, new Compare());
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i + 1);
        }

        //System.out.println("map :" + map.toString());
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            minHeap.add(new Pair(m.getValue(), m.getKey()));
        }

        List<Integer> res = new ArrayList<>();
        //System.out.println("Heap :" + minHeap.toString());
        Iterator<Pair> min = minHeap.iterator();
        while (min.hasNext()) {
            Pair pair = minHeap.poll();
            assert pair != null;
            res.add(pair.value);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}


class Pair {
    @Override
    public String toString() {
        return "Pair{" + "index=" + index + ", value=" + value + '}';
    }

    int index;
    int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

class Compare implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.index - o2.index;
    }
}