package dc.advance.stack.class2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String[] args) {
        System.out.println(getLargestRectangleArea(new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3))));
    }

    public static int getLargestRectangleArea(ArrayList<Integer> A) {

        Stack<Integer> stk = new Stack<>();
        //i = 0;
        //stk - 0
        //max = 2 * 1 =  2

        //i =1
        //stk = 1 - 1 <=5
        //stk =2  - 5 <=6
        //stk =3  - 6 <=2
        //max = 6 * 4 -2 -1 = 6
        int max_area = Integer.MIN_VALUE;
        int i = 0;
        while (i < A.size()) {
            if (stk.isEmpty() || A.get(stk.peek()) <= A.get(i)) {
                stk.push(i++);
            } else {
                int top = stk.pop();
                max_area = Math.max(max_area, A.get(top) * (stk.isEmpty() ? i : i - stk.peek() - 1));
            }
        }

        while (!stk.isEmpty()) {
            int top = stk.pop();
            max_area = Math.max(max_area, A.get(top) * (stk.isEmpty() ? i : i - stk.peek() - 1));
        }
        return max_area;
    }
}
