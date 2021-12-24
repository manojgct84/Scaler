package dc.advance.hashing2.assignment;

import java.util.HashMap;
import java.util.Map;

public class CountRightTriangles {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 1, 2}, new int[]{1, 2, 1}));
        System.out.println(getSolve(new int[]{1, 1, 2, 3, 3}, new int[]{1, 2, 1, 2, 1}));
    }

    static int mod = 1000000007;
    public static int getSolve(int[] x, int[] y) {
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for (int k : x) {
            mapX.put(k, mapX.getOrDefault(k, 0) + 1);
        }
        for (int i : y) {
            mapY.put(i, mapY.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < x.length; i++) {
            int x_axis = 0;
            int y_axis = 0;
            if (mapX.containsKey(x[i])) {
                x_axis = mapX.get(x[i]);
            }
            if (mapY.containsKey(y[i])) {
                y_axis = mapY.get(y[i]);
            }

            res = ((res % mod) + ((x_axis - 1) * (y_axis - 1)) % mod) % mod;
        }
        return res;
    }
}
