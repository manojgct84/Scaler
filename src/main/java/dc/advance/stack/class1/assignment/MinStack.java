package dc.advance.stack.class1.assignment;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stk1;
    Stack<Integer> minStk;

    public MinStack () {
        this.stk1 = new Stack<>();
        this.minStk = new Stack<>();
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 5, 2, 8, 1};
        MinStack minStack = new MinStack();
        for (int j : a) {
            minStack.push(j);
        }
        // System.out.println(minStack.minStk.toString());
    }

    public void push(int x) {

        if (stk1.isEmpty() && minStk.isEmpty()) {
            minStk.push(x);
            stk1.push(x);
        } else {
            stk1.push(x);
            if (minStk.isEmpty() || minStk.peek() > x) {
                minStk.push(x);
            } else {
                minStk.push(minStk.peek());
            }
        }
    }

    public void pop() {
        if (!stk1.isEmpty()) {
            stk1.pop();
            minStk.pop();
        }
    }

    public int top() {
        if (stk1.isEmpty()) {
            return -1;
        }
        return stk1.peek();
    }

    public int getMin() {
        if (minStk.isEmpty()) {
            return -1;
        }
        return minStk.peek();
    }
}
