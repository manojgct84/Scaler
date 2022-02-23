package dc.advance.stack.class1.home;

import java.util.Stack;

public class DoubleCharacterTrouble {

    public static void main(String[] args) {
        System.out.println(solve("abbcd"));
        System.out.println(solve("cddfeffe"));
    }

    public static String solve(String A) {
        Stack<Character> stk = new Stack<>();
        char[] chars = A.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stk.isEmpty()) {
                stk.push(chars[i]);
            } else if (stk.peek() == chars[i]) {
                stk.pop();
            }else {
                stk.push(chars[i]);
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stk.isEmpty()) {
            str.append(stk.pop());
        }
        return str.reverse().toString();
    }
}
