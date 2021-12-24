package dc.problemsolving3.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{1, 2, 3, 3, 4, 5, 6}, new int[]{3,3, 5})));
    }

    public static int[] getSolve(final int[] A, final int[] B) {
        List<Integer> res = new ArrayList<>();
        if (A.length == 0) {
            return res.stream().mapToInt(i -> i).toArray();
        }

        if (B.length == 0) {
            return A;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                map.put(B[i], map.get(B[i]) + 1);
            } else {
                map.put(B[i], 1);
            }
        }
        int i = 0;
        while (i < A.length) {
            if (map.containsKey(A[i])) {
                if (map.get(A[i]) >= 1) {
                    res.add(A[i]);
                    map.put(A[i], map.get(A[i]) - 1);
                }
            }
            i++;
        }
        return res.stream().mapToInt(k -> k).toArray();
    }
}
