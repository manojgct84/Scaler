package dc.advance.prime.assignment.Homework;

public class ExcelColumnTitle {

    public static void main(String[] args) {
        System.out.println(getSolve(27));
    }

    public static String getSolve(int A) {
        StringBuilder res = new StringBuilder();
        while (A > 0) {
            char title = (char) ('A' + ((A - 1) % 26));
            res.append(title);
            A = (A - 1) / 26;
        }
        return res.reverse().toString();
    }
}
