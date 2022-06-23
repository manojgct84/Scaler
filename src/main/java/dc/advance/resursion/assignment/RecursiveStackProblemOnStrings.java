package dc.advance.resursion.assignment;

import java.util.Arrays;
import java.util.Stack;

public class RecursiveStackProblemOnStrings {

    //Count the parenthesis
    // () - 1
    // () + ( () )  = 1 + 2 = 3
    //(() (())) =  1 + 2 * 2 = 6

    public static void main(String[] args) {
        System.out.println(recursiveStackProblemOnStrings("(() (()))"));
    }

    private static int recursiveStackProblemOnStrings(String s) {

        int[] index = new int[s.length()];
        Stack<Integer> stk = new Stack<>();
        Arrays.fill(index, 0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int t = stk.pop();
                index[t] = i;
            } else if (s.charAt(i) == '(') {
                stk.push(i);
            }
        }
        System.out.println(Arrays.toString(index));
        return recursiveParenthesis(0, s.length() - 1, index);

    }

    private static int recursiveParenthesis(int start, int end, int[] index) {

        if (start + 1 == end) {
            return 1;
        }

        if (index[start] == 0) {
            start++;
        }
        int closingBracketIndex = index[start];

        if (closingBracketIndex == end) {
            return 2 * recursiveParenthesis(start + 1, end - 1, index);
        } else {
            return recursiveParenthesis(start, closingBracketIndex, index) + recursiveParenthesis(closingBracketIndex + 1, end, index);
        }
    }
}
