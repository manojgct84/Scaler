package dc.advance.stack.class1.home;

import java.util.Stack;

public class PassingGame {

    public static void main(String[] args) {
        System.out.println(solve(10, 23, new int[]{86, 63, 60, 0, 47, 0, 99, 9, 0, 0}));
        System.out.println(solve(1, 1, new int[]{2}));
    }

    public static int solve(int A, int B, int[] C) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < C.length; i++) {
            if (stack.isEmpty()) {
                stack.push(C[i]);
            } else if (C[i] != 0) {
                stack.push(C[i]);
            } else if (C[i] == 0) {
                stack.pop();
            }
        }
        return !stack.isEmpty() ? stack.pop() : B;
    }
}
