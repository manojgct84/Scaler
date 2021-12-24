package dc.advance.resursion.backtraacking1;

import java.util.ArrayList;

public class GenerateAllParenthesesII {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    ArrayList<String> res= new ArrayList<>();
    public static ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> lst = new ArrayList<>();
        if (A == 1) {
            lst.add("()");
            return lst;
        }
        generateParenthesisRecursion(lst, "", 0, 0, A);
        return lst;
    }

    private static void
    generateParenthesisRecursion(ArrayList<String> lst, String current, int open, int close, int size) {

        if (current.length() == (2 * size)) {
            lst.add(current);
            return;
        }
        if (open < size) {
            generateParenthesisRecursion(lst, current + "(", open + 1, close, size);
        }
        if (close < open) {
            generateParenthesisRecursion(lst, current + ")", open, close + 1, size);
        }
    }
}
