package dc.advance.hashing.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortArrayGivenOrder {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 2})));
        System.out.println(Arrays.toString(getSolve(new int[]{5, 17, 100, 11}, new int[]{1, 100})));
        System.out.println(Arrays.toString(getSolve(new int[]{3, 20, 17, 17}, new int[]{5, 9, 20, 11, 6, 18, 7, 13})));
        System.out.println(Arrays.toString(getSolve(new int[]{10, 2, 18, 16, 16, 16}, new int[]{3, 13, 2, 16, 4, 19})));
    }

    public static int[] getSolve(int[] A, int[] B) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                int j = 0;
                while (j < map.get(B[i])) {
                    res.add(B[i]);
                    j++;
                }
                map.put(B[i], 0);
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int i = 0;
            while (i < e.getValue()) {
                res.add(key);
                i++;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
