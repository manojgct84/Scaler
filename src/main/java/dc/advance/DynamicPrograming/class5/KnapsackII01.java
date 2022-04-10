package dc.advance.DynamicPrograming.class5;

import java.util.Arrays;

//knapsack II 0/1
public class KnapsackII01 {

    public static void main(String[] args) {
        System.out.println(knapsack_II_01(new int[]{6, 10, 12}, new int[]{10, 20, 30}, 50));
        System.out.println(knapsack_II_01(new int[]{1, 3, 2, 4}, new int[]{12, 13, 15, 19}, 10));
        System.out.println(knapsack_II_01(new int[]{8, 5}, new int[]{1, 20}, 17));
    }

    static int[][] knapsack;

    public static int knapsack_II_01(int[] value, int[] weight, int totWeight) {
        knapsack = new int[value.length + 1][totWeight + 1];
        for (int i = 0; i <= value.length; i++) {
            Arrays.fill(knapsack[i], Integer.MIN_VALUE);
        }
        return knapsack_II_01Recursion(value, weight, value.length, totWeight);
    }

    private static int knapsack_II_01Recursion(int[] value, int[] weight, int inx, int totWeight) {

        if (inx == 0 || totWeight == 0) {
            return 0;
        }
        if (knapsack[inx][totWeight] != Integer.MIN_VALUE) {
            return knapsack[inx][totWeight];
        }

        if (totWeight >= weight[inx - 1]) {
            int x = knapsack_II_01Recursion(value, weight, inx - 1, totWeight);
            int y = value[inx - 1] + knapsack_II_01Recursion(value, weight, inx - 1, totWeight - weight[inx - 1]);
            knapsack[inx][totWeight] = Math.max(x, y);
        } else {
            knapsack[inx][totWeight] = knapsack_II_01Recursion(value, weight, inx - 1, totWeight);
        }
        return knapsack[inx][totWeight] != Integer.MIN_VALUE ? knapsack[inx][totWeight] : 0;
    }
}
