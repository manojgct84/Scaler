package dc.clazz.ProblemSolving6.Assignment.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateRowsBinaryMatrix {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[][]{
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {0, 0, 0, 1}
        })));
    }

    public static int[] getSolve(int[][] A) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (j < A[0].length) {
                stringBuilder.append(A[i][j]);
                j++;
            }
            if (map.containsKey(stringBuilder.toString())) {
                res.add(i + 1);
            } else {
                map.put(stringBuilder.toString(), i);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
