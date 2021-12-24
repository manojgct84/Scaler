package dc.advance.combinatorics.Homework;

public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.print(titleToNumber("ABCD"));
    }

    public static int titleToNumber(String A) {
        int res = 0;

        for (int i = 0; i < A.length(); i++) {
            int alphaPosition = A.charAt(i) - 'A' + 1;
            res = res * 26 + alphaPosition;
        }
        return res;
    }
}
