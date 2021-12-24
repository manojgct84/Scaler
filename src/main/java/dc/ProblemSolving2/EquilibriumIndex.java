package dc.ProblemSolving2;

public class EquilibriumIndex {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1,2,3}));
    }

    private static int getSolve(int[] A) {

        int rSide = 0;
        for (int j : A) {
            rSide += j;
        }

        int ls = 0;

        for (int i = 0; i < A.length; i++) {
            rSide -= A[i]; // leave the current index and check the rest of it.

            if (ls == rSide) return i;

            ls += A[i];
        }
        return -1;
    }
}
