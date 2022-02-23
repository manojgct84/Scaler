package dc.advance.stack.class1.assignment;

import java.util.Arrays;
import java.util.Stack;

public class SortStackAnotherStack {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{5, 4, 3, 2, 1})));
    }

    public static int[] getSolve(int[] A) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int j : A) {
            s1.push(j);
        }

        while (!s1.isEmpty()) {
            int x = s1.pop();
            while (!s2.isEmpty() && x < s2.peek()) {
                s1.push(s2.pop());
            }
            s2.push(x);
        }
        int k = A.length - 1;
        while (!s2.isEmpty()) {
            A[k--] = s2.pop();
        }
        return A;
    }
}
