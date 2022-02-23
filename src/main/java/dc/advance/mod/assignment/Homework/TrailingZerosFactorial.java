package dc.advance.mod.assignment.Homework;

public class TrailingZerosFactorial {


    public static void main(String[] args) {
        System.out.println(getSolve(5));
        System.out.println(getSolve(6));
    }


    public static int getSolve(int A) {
        int res = 0;
        int pow = 5;
        //N!/5 -> N!/25 -> N!/125... N/5^K > 0
        while ((A / pow) > 0) {
            res += A / pow;
            pow = pow * 5;
        }
        return res;
    }
}
