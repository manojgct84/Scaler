package dc.advance.Heaps.class1.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BthSmallestPrimeFraction {
    public static void main(String[] args) {
        System.out.println(bthSmallestPrimeFraction(new ArrayList<>(Arrays.asList(1, 2, 3, 5)), 3));
        System.out.println(bthSmallestPrimeFraction(new ArrayList<>(Arrays.asList(1, 7)), 1));
    }

    public static ArrayList<Integer> bthSmallestPrimeFraction(ArrayList<Integer> A, int B) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.fraction > o2.fraction) {
                    return 1;
                }
                return -1;
            }
        });

        int n = A.size();
        //Take fraction of 0- N-1
        for (int i = 0; i < A.size() - 1; i++) {
            double fact = 1D * A.get(i) / A.get(n - 1);
            Pair pair = new Pair(fact, i, n - 1);
            minHeap.add(pair);
        }
        System.out.print(minHeap.toString());

        // if the index greater than the previous index.
        // mines -1 and take the value from the array.
        while (B != 1) {
            Pair p = minHeap.poll();
            if (p.divident - 1 > p.demomator) {
                double fact = 1D * A.get(p.demomator) / A.get((p.divident - 1));
                Pair pair = new Pair(fact, p.demomator, (p.divident - 1));
                minHeap.add(pair);
            }
            B--;
        }
        return new ArrayList<>(Arrays.asList(A.get(minHeap.peek().demomator),
                A.get(minHeap.peek().divident)));
    }

    static class Pair {
        double fraction;
        //index
        int demomator;
        //index
        int divident;

        public Pair(double fraction, int demomator, int divident) {
            this.fraction = fraction;
            this.demomator = demomator;
            this.divident = divident;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "fraction=" + fraction +
                    '}';
        }
    }
}


