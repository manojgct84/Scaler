package dc.advance.TwoPointer.reversion.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SumZero {

    public static void main(String[] args) {
        System.out.println(threeSum(new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, 4))));
        System.out.println(threeSum(new ArrayList<>(Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4
                , -4, 1, -1, -4, 3, 4, -1, -1, -3))));
    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> elements = new ArrayList<>();
        int i = 0;
        Collections.sort(A);
        while (i < A.size()) {
            int j = i + 1;
            int k = A.size() - 1;
            int sum = A.get(i);
            while (j < k) {
                sum += A.get(j) + A.get(k);
                if (sum == 0) {
                    elements.add(A.get(i));
                    if (A.get(j) < A.get(k)) {
                        elements.add(A.get(j));
                        elements.add(A.get(k));
                    } else {
                        elements.add(A.get(k));
                        elements.add(A.get(j));
                    }
                    if (elements.size() != 0 && !res.contains(elements)) {
                        res.add(new ArrayList<>(elements));
                    }
                    elements.removeAll(elements);
                    j++;
                    k--;
                } else {
                    if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
                sum = A.get(i);
            }
            i++;
        }
        return res;
    }
}
