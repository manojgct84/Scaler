package dc.clazz.Hash.assignment.day2;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {


    public static void main(String[] args) {
        System.out.println(getSolution(new int[]{1,-1}));
    }

    private static int getSolution(int[] A) {

        Set<Long> set = new HashSet<>();
        set.add(Long.valueOf(A[0]));
        long[] prefixSum = new long[A.length];
        prefixSum[0] = A[0];
        //1, 3, 0
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
            if (prefixSum[i] == 0 || set.contains(Long.valueOf(prefixSum[i]))) {
                return 1;
            } else {
                set.add(Long.valueOf(prefixSum[i]));
            }
        }
        return 0;
    }
}
