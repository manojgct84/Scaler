package dc.advance.Sorting3.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BClosestPointsOrigin {

    public static void main(String[] args) {
        // System.out.println(Arrays.deepToString(getSolve(new int[][]{{1, 3}, {-2, 2}}, 1)));
        // System.out.println(Arrays.deepToString(getSolve(new int[][]{{1, -1}, {2, -1}}, 1)));
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
    }

    public static ArrayList<ArrayList<Integer>> getSolve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> priority = new PriorityQueue<>((o1, o2) -> {
            if ((o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1)) >= (o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1))) {
                return 1;
            }
            return -1;
        });
        for (List<Integer> ints : A) {
            List<Integer> lst = new ArrayList<>(ints);
            priority.add(lst);
        }

        for (int i = 0; i < B; i++) {
            res.add((ArrayList<Integer>) priority.poll());

        }
        return res;
    }
}