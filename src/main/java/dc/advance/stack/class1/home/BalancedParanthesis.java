package dc.advance.stack.class1.home;

import java.util.Stack;

public class BalancedParanthesis {

    public static void main(String[] args) {
        System.out.println(getSolve("{([])}"));
        System.out.println(getSolve("(){"));
        System.out.println(getSolve("()[]"));
    }

    public static int getSolve(String A) {
        Stack<Character> stack = new Stack<>();
        char[] chars = A.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                char check = chars[i];
                switch (check) {
                    case ')':
                        if (!(stack.peek() == '(')) {
                            return 0;
                        }
                        stack.pop();
                        break;
                    case ']':
                        if (!(stack.peek() == '[')) {
                            return 0;
                        }
                        stack.pop();
                        break;
                    case '}':
                        if (!(stack.peek() == '{')) {
                            return 0;
                        }
                        stack.pop();
                        break;
                }

            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
