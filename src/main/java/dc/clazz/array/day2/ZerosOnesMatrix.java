package dc.clazz.array.day2;

public class ZerosOnesMatrix {

    public static void main(String[] args) {
        /*System.out.println(getSolution(new int[][]{{7, 8, 8, 8},
                {7, 8, 9, 8},
                {7, 9, 9, 10}}, 9));*/
        System.out.println(getSolution(new int[][]{{0, 0, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 1}}));
    }

    private static int getSolution(int[][] A) {

        int row = 0;
        int col = 0;
        int count = 0;
        int col_len = A[0].length;

        while (row < A.length && col < A[0].length) {
            if (A[row][col] == 0) {
                col++;
            } else {
                count += col_len - col;
                col = boundryCheck(row, col, A);
                row++;
            }

        }
        return count;

    }

    private static int boundryCheck(int row, int col, int[][] A) {
        while (col >= 0 && col < A[0].length) {
            if (row < A.length - 1 && col > 0 && A[row + 1][col - 1] == 1) {
                col--;
            } else if (row < A.length - 1 && A[row + 1][col] == 1) {
                break;
            } else {
                break;
            }
        }
        return col;
    }
}
