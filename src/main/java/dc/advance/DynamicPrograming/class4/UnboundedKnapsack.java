package dc.advance.DynamicPrograming.class4;

import java.util.Arrays;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        System.out.println(unboundedKnapsack(10, new int[]{5}, new int[]{10}));
        System.out.println(unboundedKnapsack(10, new int[]{6, 7}, new int[]{5, 5}));
        System.out.println(unboundedKnapsack(10, new int[]{5}, new int[]{10}));
    }

    static int[][] knapsack01;

    public static int unboundedKnapsack(int A, int[] B, int[] C) {
        knapsack01 = new int[B.length + 1][A + 1];
        for (int i = 0; i <= B.length; i++) {
            Arrays.fill(knapsack01[i], -1);
        }
        return unboundedKnapsackRecursion(C, B, B.length, A);
    }

    private static int unboundedKnapsackRecursion(int[] weight, int[] value, int index, int totalWeight) {
        if (index == 0 || totalWeight == 0) {
            return 0;
        }
        if (knapsack01[index][totalWeight] != -1) {
            return knapsack01[index][totalWeight];
        }

        if (weight[index - 1] <= totalWeight) {
            int x = unboundedKnapsackRecursion(weight, value, index - 1, totalWeight);  // dont take it
            int y = 0;
            if (totalWeight - 2 * weight[index - 1] >= 0) { // take twice the same weight
                y = 2 * value[index - 1] + unboundedKnapsackRecursion(weight, value, index - 1, totalWeight - 2 * weight[index - 1]);
            } else { // take once.
                y = value[index - 1] + unboundedKnapsackRecursion(weight, value, index - 1, totalWeight - weight[index - 1]);
            }
            knapsack01[index][totalWeight] = Math.max(x, y);
        } else {
            knapsack01[index][totalWeight] = unboundedKnapsackRecursion(weight, value, index - 1, totalWeight);
        }
        return knapsack01[index][totalWeight];
    }

}
