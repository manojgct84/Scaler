package dc.advance.stack.class1.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[][]{{1, 5},
                {1, 7},
                {1, 5},
                {1, 7},
                {1, 4},
                {1, 5},
                {2, 0},
                {2, 0},
                {2, 0},
                {2, 0}}
        )));

        System.out.println(Arrays.toString(getSolve(new int[][]{{1, 5},
                {2, 0},
                {1, 4},
                }
        )));
    }

    public static int[] getSolve(int[][] A) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Stack<Integer>> stkOfFreq = new HashMap<>();

        int[] res = new int[A.length];
        int k = 0;
        int maxfreq = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                if (!freq.containsKey(A[i][1])) {
                    freq.put(A[i][1], 1);
                } else {
                    freq.put(A[i][1], freq.get(A[i][1]) + 1);
                }
                maxfreq = Math.max(freq.get(A[i][1]), maxfreq);
                stkOfFreq.computeIfAbsent(freq.get(A[i][1]), j -> new Stack<Integer>()).push(A[i][1]);
                res[i] = -1;
            } else if (A[i][0] == 2) {
                int x = stkOfFreq.get(maxfreq).pop();
                freq.put(x, freq.get(x) - 1);
                res[i] = x;
                if (stkOfFreq.get(maxfreq).size() == 0) {
                    maxfreq--;
                }
            }
        }
        return res;
    }
}
