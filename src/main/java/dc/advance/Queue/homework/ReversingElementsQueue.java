package dc.advance.Queue.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReversingElementsQueue {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 3));
        System.out.println(solve(new ArrayList<>(Arrays.asList(5, 17, 100, 11)), 2));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < B; i++) {
            stk.push(A.get(i));
        }
        int i = 0;
        while (!stk.isEmpty()) {
            A.set(i++, stk.pop());

        }
        return A;
    }
}
