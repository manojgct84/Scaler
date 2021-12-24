package dc.clazz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplicationPreAndNext {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{5,17,100,11})));
    }

    private static int[] getSolve(int[] A) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.length - 2; i++) {
            int c = A[i] * A[i + 2];
            res.add(c);
        }
        res.add(0, A[0] * A[1]);
        int lst = A[A.length - 2] * A[A.length - 1];
        res.add(res.size(), lst);
        return res.stream().mapToInt(i -> i).toArray();
    }
}
