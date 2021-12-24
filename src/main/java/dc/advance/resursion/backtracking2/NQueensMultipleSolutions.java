package dc.advance.resursion.backtracking2;

import java.util.ArrayList;

public class NQueensMultipleSolutions {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4).toString());
    }

    public static ArrayList<ArrayList<String>> solveNQueens(int A) {

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> solution = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < A; i++) {
            line.append(".");
        }

        for (int i = 0; i < A; i++) {
            solution.add(line.toString());
        }

        setQueen(A, 0, solution, res);
        return res;
    }

    public static void setQueen(int A, int col, ArrayList<String> temp, ArrayList<ArrayList<String>> res) {
        if (col == A) {
            res.add(new ArrayList<>(temp));
        }
        for (int row = 0; row < A; row++) {
            if (isPlaceValid(row, col, temp)) {
                setTheQueen(row, col, temp, 'Q');
                setQueen(A, col + 1, temp, res);
                setTheQueen(row, col, temp, '.'); // backtrack undo
            }
        }
    }

    public static void setTheQueen(int row, int col, ArrayList<String> temp, char queue) {
        StringBuilder sb = new StringBuilder(temp.get(row));
        sb.setCharAt(col, queue);
        temp.set(row, sb.toString());
    }

    public static boolean isPlaceValid(int row, int col, ArrayList<String> temp) {
        // For the given row , check all the col's
        for (int c = 0; c < col; c++) {
            if (temp.get(row).charAt(c) == 'Q') {
                return false;
            }
            /*if ((row + col) == (col + c) || (row - c == col - c)) {
                return false;
            }*/
        }

        // check upper diagonal \
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (temp.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // check lower diagonal /
        for (int i = row, j = col; i < temp.size() && j >= 0; i++, j--) {
            if (temp.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}
