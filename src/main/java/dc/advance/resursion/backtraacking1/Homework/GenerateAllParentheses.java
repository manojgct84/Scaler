package dc.advance.resursion.backtraacking1.Homework;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllParentheses {
    static StringBuilder res = new StringBuilder();
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(generateAllParentheses("()())()"));
    }

    private static List<String> generateAllParentheses(String str) {

        int close = 0, open = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                open++;
            } else if (str.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        System.out.println(open + " " + close);
        invalidParentheses(res, str, 0, open, close, 0);
        return ans;
    }

    private static void
    invalidParentheses(StringBuilder res, String str, int start, int open, int close, int balance) {
        if (start == str.length()) {
            if (open == 0 && close == 0) {
                ans.add(res.toString());
                res.delete(0, res.length());
            }
        } else if (balance >= 0) {
            char c = str.charAt(start);
            if (c == '(' && open > 0) {
                invalidParentheses(res, str, start + 1, open - 1, close, balance);
            } else if (c == ')' && close > 0) {
                invalidParentheses(res, str, start + 1, open, close - 1, balance);
            }

            int diff = 0;
            if (c == ')') {
                diff = -1;
            }
            if (c == '(') {
                diff = 1;
            }
            invalidParentheses(res.append(c), str, start + 1, open, close, balance + diff);
        }
    }
}
