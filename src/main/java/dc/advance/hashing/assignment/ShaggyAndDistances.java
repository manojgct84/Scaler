package dc.advance.hashing.assignment;

import java.util.HashMap;
import java.util.Map;

public class ShaggyAndDistances {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{7, 1, 3, 4, 1, 7}));
        System.out.println(getSolve(new int[]{1, 1}));

    }

    public static int getSolve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int val = map.get(A[i]);
                min = Math.min(min, i - val);
            } else {
                map.put(A[i], i);
            }
        }
        return min;
    }
}
