package dc.advance.combinatorics.Homework;

public class ConsecutiveNumbersSum {

    public static void main(String[] args) {
        System.out.println(getSolve(6));
    }

    public static int getSolve(int A) {
        int res = 0;

        if (A < 3) {
            return 1;
        }
        if (A == 3) {
            return 2;
        }

        for (int i = 1; ((i * i)) <= 2 * A; i++) {
            System.out.println("i " + i);
            //Check the Hint video for more details.
            //x + (x + 1) + (x +2) ..... A-1 = A
            int val = (A - (i * (i - 1) / 2));
            if (val % i == 0) {
                res++;
            }
        }
        return res;
    }
}
