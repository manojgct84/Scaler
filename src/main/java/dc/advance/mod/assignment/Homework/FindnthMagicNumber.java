package dc.advance.mod.assignment.Homework;

public class FindnthMagicNumber {

    public static void main(String[] args) {
        System.out.println(getSolve(3));
    }

    public static int getSolve(int A) {

        int pow = 1;
        int res = 0;

        while (A > 0) {

            pow = pow * 5;
           // System.out.println(pow);
            if ((A & 1) == 1) {
                res += pow;
            }
            A >>= 1;
        }

        return res;
    }
}
