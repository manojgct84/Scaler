package dc.clazz.array;

import java.util.HashMap;
import java.util.Map;

public class GoodPair {

    public static void main(String[] args) {
        System.out.println(getGoodPair(new int[]{510827, 351151, 96897, 925335, 299818, 192489, 456948, 44720, 510589, 598577}, 808099));
    }

    private static int getGoodPair(int[] A, int B) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[i] + A[j] == B && i != j) {
                    res.put(i, j);
                }
            }
        }
        return res.size() > 0 ? 1 : 0;
    }
}