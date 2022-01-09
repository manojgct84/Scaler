package dc.advance.Sorting2.reversion.homework.customSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).
 * <p>
 * Here, the distance between two points on a plane is the Euclidean distance.
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the
 * order that it is in.)
 * <p>
 * NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
 */
//TC : nlogn
public class BClosestPointsOrigin {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        ArrayList<Integer> add1 = new ArrayList<>();
        add1.add(26);
        add1.add(41);
        ArrayList<Integer> add2 = new ArrayList<>();
        add2.add(40);
        add2.add(47);
        ArrayList<Integer> add3 = new ArrayList<>();
        add3.add(47);
        add3.add(7);
        ArrayList<Integer> add4 = new ArrayList<>();
        add4.add(50);
        add4.add(34);
        ArrayList<Integer> add5 = new ArrayList<>();
        add5.add(18);
        add5.add(28);

        lst.add(add1);
        lst.add(add2);
        lst.add(add3);
        lst.add(add4);
        lst.add(add5);
        System.out.println(getSolve(lst, 5).toString());

        ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(3);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(-2);
        a2.add(2);
        l1.add(a1);
        l1.add(a2);
        System.out.println(getSolve(l1, 1).toString());

        a1.removeAll(a1);
        a2.removeAll(a2);

        ArrayList<ArrayList<Integer>> l2 = new ArrayList<>();
        a1.add(1);
        a1.add(-1);
        a2.add(2);
        a2.add(-1);
        l1.add(a1);
        l1.add(a2);
        System.out.println(getSolve(l1, 1).toString());
    }

    public static ArrayList<ArrayList<Integer>> getSolve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1) >= o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1)) {
                    return 1;
                }
                return -1;
            }
        });

        for (List<Integer> lst : A) {
            List<Integer> l = new ArrayList<>(lst);
            queue.add(l);
        }

        for (int i = 0; i < B; i++) {
            res.add((ArrayList<Integer>) queue.poll());
        }
        return res;
    }
}
