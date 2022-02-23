package dc.advance.stack.class2.homework;

import java.util.Stack;

public class MaximumRectangle {
    public static void main(String[] args) {
        System.out.println(solve(new int[][]{{0, 0, 1},
                {0, 1, 1},
                {1, 1, 1}}));
        System.out.println(solve(new int[][]{{0, 1, 0, 1},
                {1, 0, 1, 0}}));
        System.out.println(solve(new int[][]{{0, 1, 1},
                {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 1, 1}, {0, 1, 0}}));
    }

    public static int solve(int[][] A) {
        int i = 0;
        int[][] cache = new int[A.length][A[0].length];
        int j = 0;
        int maxArea = Integer.MIN_VALUE;
        while (i < A.length) {
            while (j < A[0].length) {
                if (i == 0) {
                    cache[i][j] = A[i][j];
                } else if (A[i][j] == 1) {
                    cache[i][j] = A[i][j] + cache[i - 1][j];
                }
                j++;
            }
            maxArea = Math.max(maxArea, calcRectangle(cache, i));
            if (j >= A[0].length - 1) {
                j = 0;
            }
            i++;
        }
        return maxArea;
    }

    private static int calcRectangle(int[][] cache, int row) {
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        while (j < cache[0].length) {
            if (stack.isEmpty() || cache[row][stack.peek()] <= cache[row][j]) {
                stack.push(j++);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, cache[row][top] * (stack.isEmpty() ? j :
                        j - stack.peek() - 1));
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            maxArea = Math.max(maxArea, cache[row][top] * (stack.isEmpty() ? j :
                    j - stack.peek() - 1));
        }

        return maxArea;
    }
}
