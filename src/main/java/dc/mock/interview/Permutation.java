package dc.mock.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

    public static void main(String[] args) {
        ArrayList<Integer> permutation = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(permutation(permutation));
    }

    public static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (input.size() == 0) {
            return res;
        }

        if (input.size() == 1) {
            res.add(new ArrayList<>(Arrays.asList(1)));
            return res;
        }

        allPermutation(res, new ArrayList<>(), input);
        return res;

    }

    public static void allPermutation(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, ArrayList<Integer> input) {

        if (temp.size() == input.size()) {
            res.add(new ArrayList<>((temp)));
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            if (temp.contains(input.get(i))) continue;
            temp.add(input.get(i));
            allPermutation(res, temp, input);
            temp.remove(temp.size() - 1);
        }
    }
}
