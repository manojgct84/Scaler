package dc.ProblemSolving2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctNumbersWindow {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{4, 1, 3, 1, 5, 2, 5, 6, 7}, 4)));
    }

    private static int[] getSolve(int[] A, int B) {


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        res.add(map.size());
        System.out.println(map.toString());
        //4, 1, 3, 1, 5, 2, 5, 6, 7

        //3, 1, 5, 2, 5, 6     count = 5
        for (int i = B; i < A.length; i++) {

            if (map.containsKey(A[i - B]) && map.get(A[i - B]) == 1) {
                map.remove(A[i - B]);
            }
            if (map.containsKey(A[i - B])) {
                map.put(A[i - B], map.get(A[i - B]) - 1);
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);

            System.out.println(map.toString());
            res.add(map.size());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
