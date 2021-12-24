package dc.advance.hashing2.homework;

import java.util.HashMap;
import java.util.Map;

public class PointOnSameLine {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{-1, 0, 1, 2, 3, 3}, new int[]{1, 0, 1, 2, 3, 4}));
        System.out.println(getSolve(new int[]{0, -3, -6, 0, -7, 0, 2, 0, 5}, new int[]{-9, -7, -8, -4, -3, 0, -9, -3, 7}));
        System.out.println(getSolve(new int[]{3, 1, 4, 5, 7, -9, -8, 6}, new int[]{4, -8, -3, -2, -1, 5, 7, -4}));
        System.out.println(getSolve(new int[]{7, -1, 7, 3, 9, -10, 6, -7, -2}, new int[]{7, -7, -4, -3, 7, -1, -6, -1, 5}));
    }

    public static int getSolve(int[] A, int[] B) {
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int equal = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j] && B[j] == B[i]) {
                    equal++;
                } else {
                    int y = B[i] - B[j];
                    int x = A[i] - A[j];
                    int g__ = gcd(y, x);
                    String str = (x / g__) + "_" + (y / g__);
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
            res = Math.max(res, equal);
            System.out.println(map.toString());
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                res = Math.max(res, e.getValue() + equal);
            }
            map.clear();
        }
        return res;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
