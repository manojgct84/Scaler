package dc.advance.resursion.backtraacking1;

public class WordSearch {

    public static void main(String[] args) {
        System.out.println(wordSearch(new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(wordSearch(new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(wordSearch(new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

    private static boolean wordSearch(char[][] board, String word) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (wordSearchDFS(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[][] directions = {{0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}};

    private static boolean wordSearchDFS(int row, int col, char[][] board, String word, int index) {
        if (index == word.length() - 1) {
            return true;
        }

        board[row][col] = '#';

        for (int i = 0; i < directions.length; i++) {
            if (validDirections(row + directions[i][0], col + directions[i][1],
                    board,
                    index,
                    word)) {
                if (wordSearchDFS(row + directions[i][0],
                        col + directions[i][1], board, word, index + 1)) {
                    return true;
                } else {
                    board[row][col] = word.charAt(index);
                }
            }
        }
        return false;
    }

    private static boolean validDirections(int x, int y, char[][] matrix, int index, String word) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == word.charAt(index);
    }
}
