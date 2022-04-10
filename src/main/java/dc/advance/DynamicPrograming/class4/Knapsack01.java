package dc.advance.DynamicPrograming.class4;

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {
        System.out.println(knapsack01(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
        System.out.println(knapsack01(new int[]{10, 20, 30, 40}, new int[]{12, 13, 15, 19}, 10));
    }

    static int[][] knapsack01;

    public static int knapsack01(int[] A, int[] B, int C) {
        knapsack01 = new int[A.length + 1][C + 1];
        for (int i = 0; i <= A.length; i++) {
            Arrays.fill(knapsack01[i], -1);
        }
        knapsnack(A, B, C, A.length);
        return knapsack01Recursion(A, B, A.length, C);
    }

    private static int knapsack01Recursion(int[] value, int[] weight, int index, int totalWeight) {

        if (index == 0 || totalWeight == 0) {
            knapsack01[index][totalWeight] = 0;
            return 0;
        }
        if (knapsack01[index][totalWeight] != -1) {
            return knapsack01[index][totalWeight];
        }

        if (totalWeight >= weight[index - 1]) {
            //Pick the value and move to next index
            int y = value[index - 1] + knapsack01Recursion(value, weight, index - 1, totalWeight - weight[index - 1]);
            //Dont pick the value, move to next index.
            int x = knapsack01Recursion(value, weight, index - 1, totalWeight - 1);
            knapsack01[index][totalWeight] = Math.max(x, y);
        } else {
            knapsack01[index][totalWeight] = knapsack01Recursion(value, weight, index - 1, totalWeight);
        }
        return knapsack01[index][totalWeight];
    }

    private static int knapsnack(int[] val, int[] wt, int W, int N) {

        if (N == 0 || W == 0) {
            return 0;
        }

        if (wt[N - 1] <= W) {
            int x = val[N - 1] + knapsnack(val, wt, W - wt[N - 1], N - 1);
            int y = knapsnack(val, wt, W, N - 1);
            return Math.max(x, y);
        }
        return knapsnack(val, wt, W, N - 1);
    }
}
