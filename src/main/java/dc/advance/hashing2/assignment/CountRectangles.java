package dc.advance.hashing2.assignment;

import java.util.HashMap;
import java.util.Map;

public class CountRectangles {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 1, 2, 2}, new int[]{1, 2, 1, 2}));
        System.out.println(getSolve(new int[]{1, 1, 2, 2, 3, 3}, new int[]{1, 2, 1, 2, 1, 2}));
        System.out.println(getSolve(new int[]{9, 5, 1, 1, 3, 7, 7, 9, 6, 9, 2, 8}, new int[]{8, 1, 5, 3, 8, 5, 4, 5, 2, 2, 7, 9}));
    }

    public static int getSolve(int[] x, int[] y) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < x.length; i++) {
            map.put(x[i] + "_" + y[i], map.getOrDefault(x[i] + "_" + y[i], 0) + 1);
        }
        System.out.println(map.toString());
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < y.length; j++) {
                if (x[i] != x[j] && y[i] != y[j]) {
                    if (map.containsKey(x[i] + "_" + y[j]) && map.get(x[i] + "_" + y[j]) == 1 &&
                            map.containsKey(x[j] + "_" + y[i]) && map.get(x[j] + "_" + y[i]) == 1) {
                        res++;
                    }
                }
            }
        }
        return res / 2;
    }
}

