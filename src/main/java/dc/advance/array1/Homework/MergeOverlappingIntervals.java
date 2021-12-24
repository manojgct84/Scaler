package dc.advance.array1.Homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        System.out.println(getSolved(intervals).toString());
    }

    //Given a collection of intervals, merge all overlapping intervals.
    public static ArrayList<Interval> getSolved(ArrayList<Interval> intervals) {

    /*Queue<Interval> priority = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });*/

        List<Interval> lst = new ArrayList<>();
        for (Interval interval : intervals) {
            lst.add(new Interval(interval.start, interval.end));
        }
        lst.sort(new Compare());
        ArrayList<Interval> res = new ArrayList<>();
        Interval prev = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            if (checkOverLapping(prev, lst.get(i))) {
                int start = Math.min(prev.start, lst.get(i).start);
                int end = Math.max(prev.end, lst.get(i).end);
                prev = new Interval(start, end);
            } else if (prev.end < lst.get(i).start) {
                res.add(prev);
                prev = lst.get(i);
            }
        }
        res.add(prev);
        return res;
    }

    private static boolean checkOverLapping(Interval prev, Interval current) {
        return prev.end >= current.start || current.end <= prev.start;
    }
}

class Interval {
    int start;
    int end;

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Compare implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
    }
}
