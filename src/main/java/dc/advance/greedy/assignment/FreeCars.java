package dc.advance.greedy.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Job Scheduling - N task - deadline
//                        - rewards
public class FreeCars {

    public static void main(String[] args) {
        System.out.println(freeCars(new ArrayList<>(Arrays.asList(1, 3, 2, 3, 3)), new ArrayList<>(Arrays.asList(5, 6, 1, 3, 9))));
        System.out.println(freeCars(new ArrayList<>(Arrays.asList(3, 8, 7, 5)), new ArrayList<>(Arrays.asList(3, 1, 7, 19))));
    }

    public static int freeCars(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Pair> pair = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            pair.add(new Pair(A.get(i), B.get(i)));
        }
        pair.sort(new ComparatorDeadline());
        //System.out.println("deadline " + pair.toString());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0;
        for (int i = 0; i < pair.size(); i++) {
            if (day < pair.get(i).deadline) {
                day++;
                minHeap.add(pair.get(i).profit);
            } else {
                if (!minHeap.isEmpty() && minHeap.peek() < pair.get(i).profit) {
                    minHeap.poll();
                    minHeap.add(pair.get(i).profit);
                }
            }
        }
        int res = 0;
        while (!minHeap.isEmpty()) {
            res += minHeap.poll();
        }

        return res;
    }

    static class Pair {
        int deadline;
        int profit;
        public Pair(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "deadline=" + deadline +
                    ", profit=" + profit +
                    '}';
        }
    }

    static class ComparatorDeadline implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o1.deadline, o2.deadline);
        }
    }
}
