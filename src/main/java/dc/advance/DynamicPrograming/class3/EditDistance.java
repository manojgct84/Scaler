package dc.advance.DynamicPrograming.class3;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("abad", "abac"));
        System.out.println(minDistance("Anshuman", "Antihuman"));
    }

    static int[][] mincost;

    public static int minDistance(String A, String B) {
        mincost = new int[A.length() + 1][B.length() + 1];
        for (int[] ints : mincost) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        return editDistanceMinCost(A, B, A.length(), B.length());
    }

    private static int editDistanceMinCost(String a, String b, int n, int m) {

        if (n == 0 && m == 0) {
            mincost[n][m] = 0;
            return 0;
        } else if (n == 0 && m > 0) {
            mincost[n][m] = m;
            return m;
        } else if (n > 0 && m == 0) {
            mincost[n][m] = n;
            return n;
        } else if (mincost[n][m] != Integer.MAX_VALUE) {
            return mincost[n][m];
        } else if (a.charAt(n - 1) == b.charAt(m - 1)) {
            return mincost[n][m] = editDistanceMinCost(a, b, n - 1, m - 1);
        } else {
            mincost[n][m] = Math.min(1 + editDistanceMinCost(a, b, n, m - 1), // insert
                Math.min(1 + editDistanceMinCost(a, b, n - 1, m),  // delete
                         1 + editDistanceMinCost(a, b, n - 1, m - 1)));// replacement
            return mincost[n][m];
        }
    }
}
