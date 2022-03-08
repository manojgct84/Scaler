package dc.advance.Heaps.class1.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BClosestPointsToOrigin {
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
        System.out.println(bClosestPointsToOrigin(lst, 5).toString());

        ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(3);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(-2);
        a2.add(2);
        l1.add(a1);
        l1.add(a2);
        System.out.println(bClosestPointsToOrigin(l1, 1).toString());

        a1.removeAll(a1);
        a2.removeAll(a2);

        ArrayList<ArrayList<Integer>> l2 = new ArrayList<>();
        a1.add(1);
        a1.add(-1);
        a2.add(2);
        a2.add(-1);
        l1.add(a1);
        l1.add(a2);
        System.out.println(bClosestPointsToOrigin(l1, 1).toString());
    }

    public static ArrayList<ArrayList<Integer>> bClosestPointsToOrigin(ArrayList<ArrayList<Integer>> A,
                                                                       int B) {

        PriorityQueue<List<Integer>> heap = new PriorityQueue(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int x1 = o1.get(0);
                int x2 = o1.get(1);

                int y1 = o2.get(0);
                int y2 = o2.get(1);

                if (x1 * x1 + x2 * x2 >= y1 * y1 + y2 * y2) {
                    return 1;
                }
                return -1;
            }
        });

        for (int i = 0; i < A.size(); i++) {
            List<Integer> lst = new ArrayList<>(A.get(i));
            heap.addAll(Collections.singleton(lst));
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            res.add((ArrayList<Integer>) heap.poll());
        }
        return res;
    }
}
