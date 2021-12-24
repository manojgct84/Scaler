package dc.advance.array1;

import java.util.ArrayList;

public class MergeIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> lst = new ArrayList<>();
        lst.add(new Interval(1, 2));
        lst.add(new Interval(3, 6));
        System.out.println(solve(lst, new Interval(10, 8)).toString());

    }
    //Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    public static ArrayList<Interval> solve(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<>();
        if (newInterval.start > newInterval.end) {
            newInterval = new Interval(newInterval.end, newInterval.start);
        }
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                res.add(interval);
            } else if ((interval.end >= newInterval.start && newInterval.start >= interval.start) ||
                    (interval.start <= newInterval.end && interval.start >= newInterval.start)) {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            } else if (interval.start > newInterval.end) {
                res.add(newInterval);
                newInterval = interval;
            }
        }

        res.add(newInterval);
        return res;
    }
}


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
