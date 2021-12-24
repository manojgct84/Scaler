package dc.advance.resursion.backtraacking1.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllUniquePermutations {

    public static void main(String[] args) {
        ArrayList<Integer> permutation = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4));
        System.out.println(getPermute(permutation).toString());
    }

    public static ArrayList<ArrayList<Integer>> getPermute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A.size() == 1) {
            res.add(new ArrayList<>(A));
            return res;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            freq.put(A.get(i), freq.getOrDefault(A.get(i), 0) + 1);
        }
        System.out.println(freq.toString());
        getUniquePermutations(freq, res, new ArrayList<>(), 0, A);
        return res;
    }

    private static void
    getUniquePermutations(Map<Integer, Integer> freq,
        ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int index, ArrayList<Integer> input) {
        if (index == input.size()) {
            if (!res.contains(temp)) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = 0; i < input.size(); i++) {
            if (freq.get(input.get(i)) > 0) {
                temp.add(input.get(i));
                freq.put(input.get(i), freq.get(input.get(i)) - 1);
                getUniquePermutations(freq, res, temp, index + 1, input);
                temp.remove(temp.size() - 1);
                freq.put(input.get(i), freq.get(input.get(i)) + 1);
            }
        }
    }
}
