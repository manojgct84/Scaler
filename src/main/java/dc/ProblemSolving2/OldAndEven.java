package dc.ProblemSolving2;


//Count ways to make sum of odd and even indexed elements equal by removing an array element
public class OldAndEven {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{2, 1, 6, 4}));
    }


    private static int getSolve(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return 0;
        }

        int lo = 0;
        int le = 0;
        int ro = 0;
        int re = 0;
        int i = 0;
        int res = 0;

        for (int j = 0; j < A.length; j++) {
            if (j % 2 != 0) {
                ro += A[j];
            } else {
                re += A[j];
            }
        }
        // System.out.println("re:" + re);
        //  System.out.println("ro:" + ro);
        while (i < A.length) {

            if (i % 2 != 0) {
                ro -= A[i];
            } else {
                re -= A[i];
            }

            if (le + ro == re + lo) {
                res++;
            }

            if (i % 2 != 0) {
                lo += A[i];
            } else {
                le += A[i];
            }
            i++;
        }

        return res;
    }
}
