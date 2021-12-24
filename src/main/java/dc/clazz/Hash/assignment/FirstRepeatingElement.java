package dc.clazz.Hash.assignment;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {

    public static void main(String[] args) {
        System.out.println(getSolution(new int[]{10, 5, 3, 4, 3, 5, 6}));
    }

    private static int getSolution(int[] A) {
        Map<Integer, Integer> a = new HashMap<>();
        for (int j : A) {
            if (a.containsKey(j)) {
                a.put(j, a.get(j) + 1);
            } else {
                a.put(j, 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (a.get(A[i]) > 1) {
                return A[i];
            }
        }
        return -1;
    }
}
