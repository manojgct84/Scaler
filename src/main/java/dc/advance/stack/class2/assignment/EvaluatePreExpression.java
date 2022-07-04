package dc.advance.stack.class2.assignment;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluatePreExpression {


    public static void main(String[] args) {
        System.out.println(evaluatePreExpression("(+12)"));
        System.out.println(evaluatePreExpression("(-32)"));
        System.out.println(evaluatePreExpression("(+(-21)(+1(-31)))"));
    }

    private static int evaluatePreExpression(String str) {

        char[] chars = str.toCharArray();
        Stack<Character> stk = new Stack<>();

        Set<Character> operator = new HashSet<>();
        operator.add('+');
        operator.add('-');
        operator.add('*');
        operator.add('/');
        int total = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (stk.isEmpty()) {
                stk.push(chars[i]);
            } else {
                if (chars[i] == ')') {
                    stk.push(chars[i]);
                } else if (chars[i] == '(') {
                    total = stk.pop() - '0';
                    stk.pop();
                    stk.push((char) (total + '0'));
                } else {
                    if (operator.contains(chars[i])) {
                        total = calculate(total, stk, String.valueOf(chars[i]));
                        stk.push((char) (total + '0'));
                    } else {
                        stk.push(chars[i]);
                    }
                }
            }
        }
        return total;
    }

    private static int calculate(int total, Stack<Character> stk, String operator) {

        int second = stk.pop() - '0';
        int first = stk.pop() - '0';

        return EvaluateExpression.calculationOperation(total, first, second, operator);
    }
}
