package dc.advance.stack.class1.home;

import java.util.Stack;

public class SimplifyDirectoryPath {

    public static void main(String[] args) {
        // System.out.println(getSolve("/a/./b/../../c/"));
        //   System.out.println(getSolve("/home/"));
        System.out.println(getSolve("/."));

    }

    private static String getSolve(String A) {

        if (A == null || A.length() == 0) {
            return "";
        }

        String[] str = A.split("/");
        //System.out.println(Arrays.toString(str));
        Stack<String> lst = new Stack<>();
        for (String value : str) {
            if (value.equals(".")) {
                continue;
            } else if (value.equals("..") && lst.isEmpty()) {
                continue;
            } else if (value.equals("..")) {
                lst.remove(lst.size() - 1);
            } else if (value.isEmpty()) {
                continue;
            } else {
                lst.add(value);
            }
        }
        if (lst.isEmpty()) {
            return "/";
        }
       // System.out.println(lst.toString());
        StringBuilder builder = new StringBuilder();
        for (String s : lst) {
            if (!s.isEmpty())
                builder.append('/').append(s);
        }
        return builder.toString();
    }
}
