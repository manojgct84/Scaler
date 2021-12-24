package dc.advance.Searching2.Homework;

public class MaximumHeightOfStaircase {

    public static void main(String[] args) {
        System.out.println(getSolve(10));
        System.out.println(getSolve(20));
        System.out.println(getSolve(4));
    }

    public static int getSolve(int A) {

        if (A == 0) {
            return 0;
        }
        if (A <= 2) {
            return 1;
        }

        if (A <= 4) {
            return 2;
        }

        int i = 1;
        int staircase = 0;
        while (i < (A / 2)) {

            if ((i * (i + 1)) / 2 > A) {
                break;
            }
            staircase = i;
            i++;
        }
        return staircase;
    }
}
