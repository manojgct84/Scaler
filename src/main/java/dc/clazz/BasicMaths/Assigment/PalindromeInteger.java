package dc.clazz.BasicMaths.Assigment;

public class PalindromeInteger {
    public static void main(String[] args) {
        System.out.println(getSolution(12121));
    }

    private static boolean getSolution(int A) {

        if (A == 0) {
            return true;
        }
        int original = A;
        int res = 0;
        int reminder = 0;
        while (A > 0) {
            reminder = A % 10;
           // System.out.println(reminder);
            res = (res * 10) + reminder;
            System.out.println(res);
            A /= 10;
        }

        return res == original;
    }

}
