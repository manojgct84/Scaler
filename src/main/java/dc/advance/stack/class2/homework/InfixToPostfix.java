package dc.advance.stack.class2.homework;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        System.out.println(getSolve("x^y/(a*z)+b"));
        System.out.println(getSolve("a+b*(c^d-e)^(f+g*h)-i"));
    }

    public static String getSolve(String A) {
        Stack<Character> stack = new Stack<>();
        char[] c = A.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            char val = c[i];
            if (operationOrder(val) > 0) {
                while (!stack.isEmpty() && operationOrder(stack.peek()) >= operationOrder(val)) {
                    res.append(stack.pop());
                }
                stack.push(val);
            } else if (val == ')') {
                char sVal = stack.pop();
                while (sVal != '(') {
                    res.append(sVal);
                    sVal = stack.pop();
                }
            } else if (val == '(') {
                stack.push(val);
            } else {
                res.append(val);
            }

        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    private static int operationOrder(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
