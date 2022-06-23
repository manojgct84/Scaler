package dc.graph.class1;

import java.util.*;

public class ValidParenthesisCount {

    //Remove invalid parenthesis and count the parenthesis

    public static void main(String[] args) {
        System.out.println(validParenthesisCountBFS("(a)())()").toString());
    }

    private static ArrayList<Integer> validParenthesisCountBFS(String s) {

        Map<String, Boolean> visited = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<String> validParenthesis = new ArrayList<>();
        int count = 0;
        boolean found = false;
        while (!q.isEmpty()) {
            String str = q.poll();
            if (visited.containsKey(str)) {
                continue;
            }
            visited.put(str, true);
            if (isBalanced(str)) {
                validParenthesis.add(str);
                res.add(++count);
                found = true;
            }
            if (found) continue;  // Only if there is no valid Parenthesis in the queue,  then
            // look for other combinations.
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                    String removedParenthesis = str.substring(0, i) + str.substring(i + 1);
                    q.add(removedParenthesis);
                }
            }
        }
        System.out.println(validParenthesis.toString());
        return res;
    }

    private static boolean isBalanced(String str) {

        int count = 0;

        char[] c = str.toCharArray();
        if (c.length == 1) return false;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                count++;
            } else if (c[i] == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}

