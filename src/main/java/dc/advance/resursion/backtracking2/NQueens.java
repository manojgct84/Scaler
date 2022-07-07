package dc.advance.resursion.backtracking2;

import java.util.Arrays;

public class NQueens {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solveNQueens(4)));
    }

    public static String[][] solveNQueens(int A) {
        String[][] queenTable = new String[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                queenTable[i][j] = ".";
            }
        }
        System.out.println("Able to place " + validateQueenPlace(A));
        int queenColumn = 0;
        setQueen(queenTable, queenColumn, A);
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                if (queenTable[i][j].equals("Q")) {
                    return queenTable;
                }
            }
        }
        return new String[][]{{}};
    }

    private static boolean setQueen(String[][] queenTable, int queenColumn, int A) {
        if (queenColumn == A) {
            return true;
        }

        for (int row = 0; row < A; row++) {
            if (isPlaceValid(queenTable, row, queenColumn)) {
                queenTable[row][queenColumn] = "Q";
                if (setQueen(queenTable, queenColumn + 1, A)) {
                    return true;
                }
                queenTable[row][queenColumn] = ".";
            }
        }
        return false;
    }

    private static boolean isPlaceValid(String[][] queenTable, int row, int queenColumn) {

        for (int col = 0; col < queenColumn; col++) {
            if (queenTable[row][col].equals("Q")) {
                return false;
            }
        }

        //Diagonal upward
        for (int i = row, j = queenColumn; i >= 0 && j >= 0; i--, j--) {
            if (queenTable[i][j].equals("Q")) {
                return false;
            }
        }
        //Diagonal downward
        for (int i = row, j = queenColumn; i < queenTable.length && j >= 0; i++, j--) {
            if (queenTable[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }

    static boolean res = false;

    public static boolean validateQueenPlace(int a) {
        boolean[] col = new boolean[a];

        boolean[] leftDiagonal = new boolean[2 * a - 1];  // N + row - col - will give the pos of
        // the diagonal cell
        boolean[] rightDiagonal = new boolean[2 * a - 1];  // row + col - will give the pos of
        // the diagonal cell
        int[][] matrix = new int[a][a];
        validateQueenPlaceBackTrack(0, col, matrix, leftDiagonal, rightDiagonal, a);
        return res;
    }


    private static void validateQueenPlaceBackTrack(
            int currentRow, boolean[] col, int[][] matrix,
            boolean[] leftDiagonal, boolean[] rightDiagonal, int size) {
        if (currentRow == size) {
            res = true;
            return;
        }

        for (int column = 0; column < size; column++) {
            if (!col[column] && !leftDiagonal[size + currentRow - column] &&
                    !rightDiagonal[currentRow + column])
            {
                matrix[currentRow][column] = 1;
                col[column] = true;
                leftDiagonal[size + currentRow - column] = true;
                rightDiagonal[currentRow + column] = true;
                validateQueenPlaceBackTrack(currentRow + 1,
                        col, matrix, leftDiagonal, rightDiagonal, size);
                matrix[currentRow][column] = 0;
                col[column] = false;
                leftDiagonal[size + currentRow - column] = false;
                rightDiagonal[currentRow + column] = false;
            }
        }
    }
}
