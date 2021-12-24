package dc.problemsolving3.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{1, 2, 2,4,5})));
    }

    public static int[] getSolve(int[] A) {
        List<Integer> res = new ArrayList<>();
        if (A.length == 0) {
            return res.stream().mapToInt(i -> i).toArray();
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                res.add(A[i - 1]);
            }
        }
        res.add(A[A.length -1]);
        return res.stream().mapToInt(i -> i).toArray();
    }
}
