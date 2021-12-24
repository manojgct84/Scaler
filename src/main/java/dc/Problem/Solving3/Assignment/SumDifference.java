package dc.Problem.Solving3.Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Combinations of arrays.
public class SumDifference {
    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{5, 4, 2}));
    }

    private static int getSolve(int[] A) {
        Arrays.sort(A);

        int max = 0;
        int min = 0;

        for (int i = 0; i < A.length; i++) {
            min = 2 * min + A[i];
            max = 2 * max + A[A.length - 1 - i];
        }
        return (((max % 1000000007) - (min % 1000000007) + 1000000007)) % 1000000007;
    }

    static List<List<Integer>> lst = new ArrayList<>();

    private static int getRecursionSolve(int[] A) {
        Arrays.sort(A);
        combination(A, 0, 0, lst);
        System.out.println(lst.toString());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (List<Integer> l : lst) {
            max = Math.max(max, l.get(l.size() - 1));
            min = Math.min(min, l.get(0));
            ans = (max % 1000000007) - (min % 1000000007);
        }
        return ans;
    }


    private static void combination(int[] a, int s, int e, List<List<Integer>> lst) {

        if (a.length == e) {
            return;
        } else if (s > e)
            combination(a, 0, e + 1, lst);

        else {
            List<Integer> comb = new ArrayList<>();
            for (int i = s; i < e; i++) {
                comb.add(a[i]);
            }
            comb.add(a[e]);
            lst.add(comb);
            combination(a, s + 1, e, lst);
        }
    }

}
