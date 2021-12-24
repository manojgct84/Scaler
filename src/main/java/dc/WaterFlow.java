package dc;

public class WaterFlow {

    /**
     * Given an N x M matrix A of non-negative integers representing the height of each unit cell in a continent, the "Blue lake" touches the left and top edges of the matrix and the "Red lake" touches the right and bottom edges.
     * <p>
     * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
     * <p>
     * Find the number of cells from where water can flow to both the Blue and Red lake.
     * <p>
     * ex:
     * A = [
     * [1, 2, 2, 3, 5]
     * [3, 2, 3, 4, 4]
     * [2, 4, 5, 3, 1]
     * [6, 7, 1, 4, 5]
     * [5, 1, 1, 2, 4]
     * ]
     *
     * @param A
     * @return
     */

    public static void main(String args[]) {
   /*     System.out.println(solve(new int[][]{{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}}));*/
        System.out.println(solve(new int[][]{
                {15, 1, 10},
                {5, 19, 19},
                {3, 5, 6},
                {6, 2, 8},
                {2, 12, 16},
                {3, 8, 17},
                {12, 5, 3},
                {14, 13, 3},
                {2, 17, 19},
                {16, 8, 7},
                {12, 19, 10},
                {13, 8, 20}
        }));

    }

    public static int solve(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] leftHalf = new boolean[row][col];
        boolean[][] rightHalf = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            dfs(matrix, leftHalf, Integer.MIN_VALUE, i, 0);
            dfs(matrix, rightHalf, Integer.MIN_VALUE, i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            dfs(matrix, leftHalf, Integer.MIN_VALUE, 0, i);
            dfs(matrix, rightHalf, Integer.MIN_VALUE, row - 1, i);
        }

        int res = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (leftHalf[i][j] && rightHalf[i][j]) {
                        res++;
                }
            }
        }
        return res;
    }

    static int[][] dist = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private static void dfs(int[][] matrix, boolean[][] visited, int prev, int x, int y) {
        int n = matrix.length;
        int m = matrix[0].length;
       if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < prev)
            return;

        visited[x][y] = true;

        for (int[] i : dist) {
            dfs(matrix, visited, matrix[x][y], x + i[0], y + i[1]);
        }
    }

}
