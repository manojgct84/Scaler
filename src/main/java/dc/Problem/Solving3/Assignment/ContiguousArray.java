package dc.Problem.Solving3.Assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static void main(String[] args) {
        System.out.println(getMapSolve(new int[]{0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1 }));
    }

    private static int getSolve(int[] A) {
        //One way to solve it.
        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        //System.out.println(Arrays.toString(prefixSum));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int len = j - i + 1;
                int sum = len / 2;
                int pf = prefixSum[j] - prefixSum[i];
                if (sum == pf)
                    max = Math.max(max, len);
            }
        }
        return max;
    }

    private static int getMapSolve(int[] A) {
        //One way to solve it using map
        int[] zerosTOOnes = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zerosTOOnes[i] = -1;
            } else {
                zerosTOOnes[i] = A[i];
            }
        }
        int[] prefixSum = new int[A.length];
        prefixSum[0] = zerosTOOnes[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = zerosTOOnes[i] + prefixSum[i - 1];
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        System.out.println(Arrays.toString(prefixSum));
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(prefixSum[i])) {
                System.out.println("i " + i + " prefixSum "+ prefixSum[i]);
                max = Math.max(max, i - map.get(prefixSum[i]));
            } else {
                map.put(prefixSum[i], i);
            }
        }
        System.out.println(map.toString());
        return max;
    }
}
