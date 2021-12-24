package dc.advance.prime.assignment.Homework;

public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.println(getSolve("ABCD"));
    }

    public static int getSolve(String A) {
        int res = 0;
        for (int i = 0; i < A.length(); i++) {
            int val = A.charAt(i) - 'A' + 1;
            System.out.println("val " + val);
            res = res * 26 + val;
            System.out.println("res " + res);
        }
        return res;
    }
}
