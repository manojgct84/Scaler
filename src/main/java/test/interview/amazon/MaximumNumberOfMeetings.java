package test.interview.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumNumberOfMeetings {

    public static void main(String args[]) {
        List<Integer> arrival = new ArrayList<>();
        arrival.add(1);
        arrival.add(3);
        arrival.add(3);
        arrival.add(5);
        arrival.add(7);

        List<Integer> duration = new ArrayList<>();
        duration.add(2);
        duration.add(2);
        duration.add(1);
        duration.add(2);
        duration.add(1);
        System.out.println(getSolution(arrival, duration));
    }

    private static int getSolution(List<Integer> arrival, List<Integer> duration) {
        List<OverLap> lst = new ArrayList<>();
        for (int i = 0; i < arrival.size(); i++) {
            lst.add(new OverLap(arrival.get(i), arrival.get(i) + duration.get(i) - 1));
        }
        lst.sort(new Compare());
        int res = 0;
        int end = Integer.MIN_VALUE;
        for (OverLap O : lst) {
            if (O.getStart() >= end) {
                res++;
                end = O.getEnd();
            }
        }
        return res;
    }
}


class OverLap {
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    int start;

    public OverLap(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int end;

}

class Compare implements Comparator<OverLap> {
    @Override
    public int compare(OverLap o1, OverLap o2) {
        return Integer.compare(o1.end, o2.end);
     }
}

