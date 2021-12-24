package dc.mock.interview;

public class StairCase {

    public static void main(String[] args) {
        System.out.println((getSolve(27)));

    }

    private static int getSolve(int A) {
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
        int stairCase = 0;
        while (i < A / 2) {

            if ((i * (i + 1)) / 2 > A) {
                break;
            }
            stairCase = i;
            i++;
        }
        return stairCase;
    }
}
