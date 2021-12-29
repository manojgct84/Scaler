package dc.advance.TwoPointer.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsGivenDifference {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 5, 3, 4, 2}, 3));
        System.out.println(getSolve(new int[]{8, 12, 16, 4, 0, 20}, 4));
        System.out.println(getSolve(new int[]{1, 1, 1, 2, 2}, 0));
        System.out.println(getSolve(new int[]{8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8,
                7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3}, 3));
        System.out.println(getSolve(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0));
    }

    //Count all distinct pairs with difference equal to B.
    public static int getSolve(int[] A, int K) {
        Arrays.sort(A);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int j : A) {
            freq.put(j, freq.getOrDefault(j, 0) + 1);
        }
        int count = 0;
        System.out.println(freq.toString());

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();
            int find = key + K;
            if (K == 0 && value > 1) {
                count++;
            } else if (K != 0 && freq.containsKey(find)) {
                count++;
            }
        }
        return count;
    }

    //Count all distinct pairs with difference equal to B.
    public static int getScalerSolve(int[] A, int B) {
        Arrays.sort(A);
        int i = 0, j = 1;
        long ans = 0;
        while (j < A.length) {
            if (j == i) {
                j++;
                continue;
            }
            int x = A[i], y = A[j];
            if (y - x == B) {
                ans++;
                while (i < A.length && A[i] == x) i++;
                while (j < A.length && A[j] == y) j++;
            } else if (y - x > B) {
                i++;
            } else {
                j++;
            }
        }
        return (int) ans;
    }
}
