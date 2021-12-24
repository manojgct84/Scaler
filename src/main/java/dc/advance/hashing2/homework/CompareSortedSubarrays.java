package dc.advance.hashing2.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompareSortedSubarrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{1, 7, 11, 8, 11, 7, 1}, new int[][]{{0, 2, 4, 6}})));
        System.out.println(Arrays.toString(getSolve(new int[]{1, 3, 2}, new int[][]{{0, 1, 1, 2}})));
        System.out.println(Arrays.toString(getSolve(new int[]{0, 100000}, new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 1}})));
    }


    public static int[] getSolve(int[] A, int[][] B) {
        int[] res = new int[B.length];
        long[] pref = new long[A.length + 1];
        //pref[0] = Long.hashCode(A[0]);
        pref[0] = 0;
        Map<Integer, Integer> hashValue = hashFun(A);
        System.out.println(hashValue.toString());
        int k = 1;
        for (int i = 0; i < A.length; i++) {
            pref[k] = pref[k - 1] + hashValue.get(A[i]);
            k++;
        } ///

        System.out.println(Arrays.toString(pref));

        for (int i = 0; i < B.length; i++) {
            int l1 = B[i][0];
            int r1 = (B[i][1] + 1);
            int l2 = B[i][2];
            int r2 = (B[i][3] + 1);
            if ((r1 - l1) == (r2 - l2)) {
                res[i] = (pref[r1] - pref[l1]) == (pref[r2] - pref[l2]) ? 1 : 0;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    private static Map<Integer, Integer> hashFun(int[] a) {
        Map<Integer, Integer> hashValue = new HashMap<>();
        int maxPrime = 1000000007;
        int min = 1;
        int range = (maxPrime - min + 1);
        for (int j : a) {
            if (!hashValue.containsKey(j)) {
                int val = (int) (1L * Math.random() * range + min);
                /*if (set.contains(val)) {
                    while (set.contains(val)) {
                        val = (int) (1L * Math.random() * range + min);
                    }
                }*/
                hashValue.put(j, val);
                //set.add(val);
            }
        }
        return hashValue;
    }
}
