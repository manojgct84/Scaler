package dc.advance.Heaps.class2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NMaxPairCombinations {

    public static void main(String[] args) {
        System.out.println(nMaxPairCombinations(new ArrayList<>(Arrays.asList(1, 4, 2, 3)), new ArrayList<>(Arrays.asList(2, 5, 1, 6))));
        System.out.println(nMaxPairCombinations(new ArrayList<>(Arrays.asList(2, 4, 1, 1)), new ArrayList<>(Arrays.asList(-2, -3, 2, 4))));
    }

    public static ArrayList<Integer> nMaxPairCombinations(ArrayList<Integer> A, ArrayList<Integer> B) {
        //Max Heap
        PriorityQueue<HeapPair> maxHeap = new PriorityQueue<>(new Comparator<HeapPair>() {
            @Override
            public int compare(HeapPair o1, HeapPair o2) {
                return o1.sum >= o2.sum ? -1 : 1;
            }
        });
        Set<String> set = new HashSet<>();
        Collections.sort(A);
        Collections.sort(B);


        int i = A.size() - 1;
        int j = A.size() - 1;

        maxHeap.add(new HeapPair(A.get(i) + B.get(j), i, j));
        set.add(i + "_" + j);
        ArrayList<Integer> res = new ArrayList<>();

        while (res.size() < A.size()) {
            HeapPair heapPair = maxHeap.poll();
            res.add(heapPair.sum);
            i = heapPair.indexi;
            j = heapPair.indexj;
            if ((j - 1) < 0 || (i - 1) < 0) { //if the index reaches < 0 we break.
                break;
            }
            System.out.println("sum-" + heapPair.sum + " i-" + i + " j-" + j);
            if (set.contains((i -1) + "_" + (j-1))) { // we don't need to process the same index
                // when we come across.
                continue;
            }
            maxHeap.add(new HeapPair(A.get(i - 1) + B.get(j), i - 1, j));
            set.add(i + "_" + j);
            maxHeap.add(new HeapPair(A.get(i) + B.get(j - 1), i, j - 1));
            set.add(i + "_" + j);
        }
        return res;
    }

    static class HeapPair {
        int sum;
        int indexi;
        int indexj;

        public HeapPair(int sum, int indexi, int indexj) {
            this.sum = sum;
            this.indexi = indexi;
            this.indexj = indexj;
        }
    }
}


