package dc.advance.resursion.backtracking2.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 8));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
       // System.out.println(combinationSum(A, 2));
       // System.out.println(combinationSum(B, 7));
        System.out.println(combinationSum(C, 28));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        findCombinationSum(res, A, B, 0, new ArrayList<>());
        return res;

    }

    private static void
    findCombinationSum(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A, int B, int start, ArrayList<Integer> temp) {
        int cal = checkSumForB(temp);
        if (cal >= B) {
            if (cal == B && !res.contains(temp)) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (start == A.size()) {
            return;
        }

        for (int i = start; i < A.size(); i++) {
            if (A.get(i) > B) continue;
            temp.add(A.get(i));
            findCombinationSum(res, A, B, i, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private static int checkSumForB(ArrayList<Integer> temp) {
        int sum = 0;
        for (Integer t : temp) {
            sum += t;
        }
        return sum;
    }
}
