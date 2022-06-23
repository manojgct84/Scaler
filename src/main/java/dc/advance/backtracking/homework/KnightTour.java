package dc.advance.backtracking.homework;

import java.util.Arrays;

public class KnightTour {
    public int[][] solve(int A) {

        int[][] solution = new int[8][8];

        for (int i = 0; i < solution.length; i++) {
            Arrays.fill(solution[i], 10);
        }

        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        knightTour(A, solution, 0, 0, direct);
        return solution;

    }

    private boolean knightTour(int a, int[][] solution, int row, int col, int[][] directions) {

        if (row  == a * a) {
            return true;
        }

        int nextR = 0;
        int nextC = 0;
        for (int i = 0; i < 8; i++) {
             nextR = row + directions[i][1];
            nextC = col + directions[0][i];
             if (directionValid(nextR,nextC, solution)) {
                  if (knightTour(a,  solution, nextR + 1, nextC,directions)) {
                      return true;
                 } else {
                      solution[nextR][nextC] = -1;
                  }
            }
        }
        return false;
    }

    public static boolean directionValid(int row, int col, int[][] solution) {

        return row >= 0 && col >= 0 && row < solution.length &&
                col < solution[0].length && solution[row][col] == -1;
    }
}
