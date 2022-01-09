package dc.advance.Sorting2.reversion.assignment;

/**
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, …, (N-1)], if we split
 * the array into some number of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.
 * <p>
 * What is the most number of chunks we could have made?
 */
public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, 4, 0}));
        System.out.println(solve(new int[]{2, 1, 0, 3}));
    }

    /**
     * 0 1 2 3
     * [2,0,1,3]
     * we need to two value to make it swap
     * max = 2 and i =0   C =0
     * max = 2 and i =1   C =0
     * max = 2 and i =2   C =1
     * max = 3 and i =3   C =2
     */

    public static int solve(int[] A) {
        int max = 0x80000000;// Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}
