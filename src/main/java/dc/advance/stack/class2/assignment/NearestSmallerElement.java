package dc.advance.stack.class2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {
        System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8))));
    }

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (stk.isEmpty()) {
                stk.push(A.get(i));
                res.add(-1);
            } else {
                while (!stk.isEmpty() && stk.peek() >= A.get(i)) {
                    stk.pop();
                }
                if (!stk.isEmpty()) {
                    res.add(stk.peek());
                } else {
                    res.add(-1);
                }
                stk.push(A.get(i));
            }
        }
        return res;
    }
}