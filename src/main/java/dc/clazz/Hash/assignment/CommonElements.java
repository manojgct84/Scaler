package dc.clazz.Hash.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolution(new int[]{2, 1, 4, 10}, new int[]{3, 6, 2, 10, 10})));
    }

    private static int[] getSolution(int[] A, int[] B) {

        Map<Integer, Integer> a = new HashMap<>();
        Map<Integer, Integer> b = new HashMap<>();

        for (int j : A) {
            if (a.containsKey(j)) {
                a.put(j, a.get(j) + 1);
            } else {
                a.put(j, 1);
            }
        }
        for (int j : B) {
            if (b.containsKey(j)) {
                b.put(j, b.get(j) + 1);
            } else {
                b.put(j, 1);
            }
        }
        List<Integer> res = new ArrayList<>();

        for (Map.Entry<Integer,Integer> map : a.entrySet()) {

            if (b.containsKey(map.getKey())) {
                int bCount = b.get(map.getKey());
                int aCount = (int) map.getValue();
                if (bCount <= aCount) {
                    for (int i = 0; i < bCount; i++) {
                        res.add((Integer) map.getKey());
                    }
                } else if (aCount <= bCount) {
                    for (int i = 0; i < aCount; i++) {
                        res.add((Integer) map.getKey());
                    }
                } else {
                    res.add((Integer) map.getKey());
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
