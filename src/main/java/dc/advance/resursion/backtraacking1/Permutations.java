package dc.advance.resursion.backtraacking1;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {
        ArrayList<Integer> permutation = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(getPermute(permutation));
    }

    public static ArrayList<ArrayList<Integer>> getPermute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        getPermuteRecursion(res, new ArrayList<>(), A, 0);
        return res;
    }

    private static void
    getPermuteRecursion(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, ArrayList<Integer> a, int index) {
        if (index == a.size()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < a.size(); i++) {
            if (temp.contains(a.get(i))) continue;
            temp.add(a.get(i));
            getPermuteRecursion(res, temp, a, index + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
