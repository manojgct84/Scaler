package dc.clazz.Hash.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoOutOfThree {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTwoOutOfThree(new int[]{2}, new int[]{3}, new int[]{1, 1, 2, 3})));
    }

    //3,4,4    2,3
    private static int[] getTwoOutOfThree(int[] A, int[] B, int[] C) {

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        while (i < A.length) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            }
            i++;
        }
        int j = 0;
        while (j < B.length) {
            if (map.containsKey(B[j])) {
                map.put(B[j], map.get(B[j]) + 1);
            } else {
                map.put(B[j], 1);
            }
            j++;
        }
        System.out.println(map.toString());
        Set<Integer> set = Arrays.stream(C).boxed().collect(Collectors.toSet());
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            } else if (set.contains(entry.getKey()) && entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        return res.stream().mapToInt(k -> k).toArray();
    }
}
