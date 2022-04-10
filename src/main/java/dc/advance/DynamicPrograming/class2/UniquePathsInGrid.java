package dc.advance.DynamicPrograming.class2;

public class UniquePathsInGrid {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {1, 1, 1}, {0, 0, 0}}));
    }

    static int[][] path;

    public static int uniquePathsWithObstacles(int[][] A) {
        path = new int[A.length][A[0].length];
        uniquePathsWithObstaclesRecursion(A, A.length - 1, A[0].length - 1, 0, 0);
        uniquePathsWithObstaclesIterative(A);
        return path[A.length - 1][A[0].length - 1];
    }

    private static int uniquePathsWithObstaclesRecursion(
            int[][] a, int row, int col, int r, int c) {
        if (row == r || col == c) {
            return 1;
        }

        if (a[r][c] == 1) {
            return 0;
        }

        path[r][c] =
                uniquePathsWithObstaclesRecursion(a, row, col, r + 1, c)
                        + uniquePathsWithObstaclesRecursion(a, row, col, r, c + 1);
        return path[r][c];
    }

    private static void uniquePathsWithObstaclesIterative(int[][] a) {
        if (a[0][0] == 0) {
            path[0][0] = 1;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] == 0) {
                path[i][0] = path[i - 1][0];
            }

        }

        for (int i = 1; i < a[0].length; i++) {
            if (a[0][i] == 0) {
                path[0][i] = path[0][i - 1];
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }
    }
}
