package dc.advance.hashing.assignment;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{2, 1}));
        System.out.println(longestConsecutive(new int[]{100, 4, 3, 6, 10, 20, 11, 5, 101}));
    }

    public static int longestConsecutive(final int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int j : A) {
            set.add(j);
        }
        int chain = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            chain = 0;
            if (!set.contains(A[i] - 1)) {
                int x = A[i] + 1;
                chain = 1;
                while (set.contains(x)) {
                    x++;
                    chain++;
                }
            }
            max = Math.max(max, chain);
        }
        return max;
    }
}
