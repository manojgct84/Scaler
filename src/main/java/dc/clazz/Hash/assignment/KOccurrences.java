package dc.clazz.Hash.assignment;

import java.util.HashMap;
import java.util.Map;

public class KOccurrences {


    public static void main(String[] args) {
        System.out.println(getKOccurrences(5, 2, new int[]{1, 2, 2, 3, 3}));
    }

    private static int getKOccurrences(int N, int K, int[] A) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int j : A) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        //System.out.println(map.toString());
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == K) {
                sum = (sum + entry.getKey());
            }
        }
         System.out.println(sum);
        return sum == 0 ? -1 : sum %  (100000000 + 7);
    }


}
