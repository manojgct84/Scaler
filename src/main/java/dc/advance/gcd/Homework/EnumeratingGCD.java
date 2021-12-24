package dc.advance.gcd.Homework;

public class EnumeratingGCD {

    public static void main(String[] args) {
        System.out.println(getSolve("1", "2"));
    }

    public static String getSolve(String A, String B) {

        if (A.equals(B)) {
            return A;
        } else {
              return "1";
        }
    }
}
