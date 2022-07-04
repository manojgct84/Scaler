package dc.advance.resursion.backtraacking1.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetsII {

    public static void main(String[] args) {
        System.out.println(getSubsetsWithDup(new ArrayList<>(Arrays.asList(1, 2, 2))));
    }

    public static ArrayList<ArrayList<Integer>> getSubsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        subsetsWithDup(res, A, 0, new ArrayList<>());
        return res;
    }

    private static void
    subsetsWithDup(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A, int start, ArrayList<Integer> temp) {

        if (!res.contains(temp)) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = start; i < A.size(); i++) {
            temp.add(A.get(i));
            subsetsWithDup(res, A, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
