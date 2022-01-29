package dc.advance.Searching.reversion.homework;

public class MatrixSearch {
    public static void main(String[] args) {
        System.out.println(getSearchMatrix(new int[][]{{0}}, 1));
        System.out.println(getSearchMatrix(new int[][]{
                {
                        1, 3, 5, 7
                },
                {
                        10, 11, 16, 20
                },
                {
                        23, 30, 34, 50
                }
        }, 3));
    }

    public static int getSearchMatrix(int[][] A, int B) {
        if (A.length == 0) {
            return -1;
        }
        int i = 0;
        int j = A[0].length - 1;

        while (i < A.length && j >= 0) {

            if (A[i][j] < B) {
                i++;
            } else if (A[i][j] > B) {
                j--;
            } else if (A[i][j] == B) {
                return 1;
            }
        }
        return 0;
    }
}
