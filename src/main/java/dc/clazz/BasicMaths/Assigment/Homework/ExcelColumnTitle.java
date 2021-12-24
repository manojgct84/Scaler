package dc.clazz.BasicMaths.Assigment.Homework;

public class ExcelColumnTitle {

    public static void main(String[] args) {
        System.out.println(getSolution(28));
    }

    private static String getSolution(int A) {
        StringBuilder res = new StringBuilder();
        while (A > 0) {
            char a = (char) ('A' + ((A - 1) % 26));
            res.append(a);
            A = (A - 1) / 26;
        }
        return res.reverse().toString();
    }
}
