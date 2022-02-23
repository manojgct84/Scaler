package dc.advance.stack.class2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        System.out.println(getEvalRPN(new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*"))));
        System.out.println(getEvalRPN(new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"))));
        System.out.println(getEvalRPN(new ArrayList<>(Arrays.asList("5", "1", "2", "+", "4", "*",
                "+", "3", "-"))));
    }

    public static int getEvalRPN(ArrayList<String> A) {
        Set<String> operator = new HashSet<>();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
        Stack<String> stk = new Stack<>();
        int total = 0;
        for (int i = 0; i < A.size(); i++) {
            if (stk.isEmpty()) {
                stk.push(A.get(i));
            } else {
                if (operator.contains(A.get(i))) {
                    total = calculate(total, stk, A.get(i));
                    stk.push(String.valueOf(total));
                } else {
                    stk.push(A.get(i));
                }
            }
        }
        return total;
    }

    private static int calculate(int total, Stack<String> stk, String operator) {

        int second = Integer.parseInt(stk.pop());
        int first = Integer.parseInt(stk.pop());

        switch (operator) {
            case "+":
                total = second + first;
                break;
            case "-":
                total = first - second;
                break;
            case "*":
                total = second * first;
                break;
            case "/":
                total = first / second;
                break;
        }
        return total;
    }
}
