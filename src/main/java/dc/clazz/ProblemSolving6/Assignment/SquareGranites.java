package dc.clazz.ProblemSolving6.Assignment;

public class SquareGranites {
    public static void main(String[] args) {
        System.out.println(getSolve(62, 34, 89));
    }

    public static int getSolve(int A, int B, int C) {
        /*int a = A - C;
        int b = B - C;
        int res = 1;

        while (a > 0 || b > 0) {
            System.out.println("a " + a + " b " + b);
            if (a > 0 && a <= C) {
                res++;
            }

            if (b > 0 && b <= C) {
                res++;
            }
            a = a - C;
            b = a - C;
        }

        if (a < 0 && b < 0) {
            res++;
        }*/

        int a = (int) Math.ceil((double) A / (double) C);
        int b = (int) Math.ceil((double) B / (double) C);
        System.out.println("a " + a + " b " + b);
        return a * b;
    }
}
