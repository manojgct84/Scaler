package dc.clazz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddEvenSubSeq {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(oddEvenSub(new int[]{13, 10, 28, 37, 43, 40, 14, 12, 48})));
    }

    private static int[] oddEvenSub(int[] A) {
        if (A.length == 0) {
            return A;
        }
        int len = A.length;
        boolean even = (A[0] & 1) == 0 ? false : true;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if ((A[i] & 1) == 0 && !even) {
                res.add(A[i]);
                even = true;
            } else if ((A[i] & 1) == 1 && even) {
                res.add(A[i]);
                even = false;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
