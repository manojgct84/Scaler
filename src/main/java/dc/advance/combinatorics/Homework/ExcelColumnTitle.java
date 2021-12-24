package dc.advance.combinatorics.Homework;

public class ExcelColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
    }

    public static String convertToTitle(int A) {
        StringBuilder res = new StringBuilder();
        while (A > 0) {
            char alpha = (char) ('A' + (A - 1) % 26);
            res.append(alpha);
            A = (A - 1) / 26;
        }
        return res.reverse().toString();
    }
}
