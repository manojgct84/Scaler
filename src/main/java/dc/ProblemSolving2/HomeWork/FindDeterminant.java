package dc.ProblemSolving2.HomeWork;

public class FindDeterminant {
    public static void main(String[] args) {
        System.out.println(getSolve(new int[][]{{6, 1, 1},
                {4, -2, 5},
                {2, 8, 7}}));


    }

    private static int getSolve(int[][] A) {

        if (A.length == 2) {
            return (A[0][0] * A[1][1]) - (A[0][1] * A[1][0]);
        }

        int c = 0;
        int r = 0;
        while (c < A[0].length) {
            int a = A[r][c] * ((A[r + 1][c + 1] * A[r + 2][c + 2]) - (A[r + 2][c + 1] * A[r + 1][c + 2]));
            int b = A[r][c + 1] * ((A[r + 1][c] * A[r + 2][c + 2]) - (A[r + 1][c + 2] * A[r + 2][c]));
            int z = A[r][c + 2] * ((A[r + 1][c] * A[r + 2][c + 1]) - (A[r + 2][c] * A[r + 1][c + 1]));
            System.out.printf("a %s , b %s , c %s", a, b, z);
            c = c + 2;
            return (a - b + z);
        }
        return -1;
    }
}
