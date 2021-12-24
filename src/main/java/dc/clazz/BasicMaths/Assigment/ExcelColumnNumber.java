package dc.clazz.BasicMaths.Assigment;

public class ExcelColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ABCD"));
    }

    private static int titleToNumber(String A) {
        int result = 0;

        for (int i = 0; i < A.length(); i++) {
            int d = A.charAt(i) - 'A' + 1;
            result = result * 26 + d;
        }
        return result;
    }
}
