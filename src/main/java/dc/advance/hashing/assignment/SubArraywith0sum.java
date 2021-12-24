package dc.advance.hashing.assignment;

import java.util.HashMap;
import java.util.Map;

public class SubArraywith0sum {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 2, 3, 4, 5}));
        System.out.println(getSolve(new int[]{-1, 1}));
        System.out.println(getSolve(new int[]{96, -71, 18, 66, -39, -32, -16, -83, -11, -92, 55,
                66, 93, 5, 50, -45, 66, -28, 69, -4, -34, -87, -32, 7, -53, 33, -12, -94, -80,
                -71, 48, -93, 62}));
        System.out.println(getSolve(new int[]{862, -411, -552, -549, 918, 434, 29, -437, 121, -640, -168, -961, 929, -427, 372, 984, 488, -756, 674, -149, 945, 566, 391, -970, -44, 689, -128, -326, 43, -312, 469, 817, -349, 260, 590, -106, -700, 484, -735, -423, 660, 450, -1148, -237, -844, 62, 513, 506, 382, 77, 244, 335}));
    }

    public static int getSolve(int[] A) {
        Map<Long, Integer> map = new HashMap<>();

        long pref = 0;
        map.put(0L, 0);
        for (int i = 0; i < A.length; i++) {
            pref = pref + (A[i]);
            if (map.containsKey(pref)) {
                return 1;
            } else {
                map.put(pref, i);
            }
        }
        return 0;
    }
}
