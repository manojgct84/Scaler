package dc.advance.greedy.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FinishMaximumJobs {

    public static void main(String[] args) {
        System.out.println(finishMaximumJobs(new ArrayList<>(Arrays.asList(1, 5, 7, 1)), new ArrayList<>(Arrays.asList(7, 8, 8, 8))));
        System.out.println(finishMaximumJobs(new ArrayList<>(Arrays.asList(3, 2, 6)), new ArrayList<>(Arrays.asList(9, 8, 9))));
        System.out.println(finishMaximumJobs(new ArrayList<>(Arrays.asList(3, 5)),
                new ArrayList<>(Arrays.asList(4, 14))));
    }

    public static int finishMaximumJobs(ArrayList<Integer> A, ArrayList<Integer> B) {
        List<Pair> jobInterval = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            jobInterval.add(new Pair(A.get(i), B.get(i)));
        }
        jobInterval.sort(new CompareEndTime());

        int maxjob = 1;
        int end = jobInterval.get(0).end;
        for (int i = 1; i < jobInterval.size(); i++) {
             if (jobInterval.get(i).start >= end) {
                 maxjob++;
                 end = jobInterval.get(i).end;
             }
        }
        return maxjob;
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class CompareEndTime implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o1.end, o2.end);
        }
    }
}
