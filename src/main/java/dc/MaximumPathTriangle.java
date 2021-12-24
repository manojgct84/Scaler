package dc;

/**
 * Given a 2D integer array A of size N * N representing a triangle of numbers.
 * <p>
 * Find the maximum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * NOTE:
 * <p>
 * Adjacent cells to cell (i,j) are only (i+1,j) and (i+1,j+1)
 * Row i contains i integer and n-i zeroes for all i in [1,n] where zeroes represents empty cells.
 */
public class MaximumPathTriangle {


    public static void main(String[] args) {
        //System.out.println(getMaximumPathTriangle(new int[][]{{3,0,0,0},{7,4,0,0},{2,4,6,0},{8,5,9,3}}));
        //System.out.println(getBottomToTop(new int[][]{{3,0,0,0},{7,4,0,0},{2,4,6,0},{8,5,9,3}}));
        //System.out.println(getBottomToTop(new int[][]{{8,0,0,0},{4,4,0,0},{2,2,6,0},{1,1,1,1}}));
         System.out.println(getBottomToTop(new int[][]{{8,0,0,0},{4,4,0,0},{2,2,6,0},{1,1,1,1}}));
    }

    private static int getMaximumPathTriangle(int[][] ints) {

        if (ints.length == 0) {
            return 0;
        }

        if (ints[0].length == 0) {
            return 0;
        }

        int sum = ints[0][0];
        int max = 0;
        int row = ints.length;
        int cols = ints[0].length;
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < cols -1; j++) {
                 if (ints[i][j] !=0) {
                     max = Math.max(ints[i + 1][j], ints[i + 1][j + 1]);
                 } else {
                     break;
                 }
            }
            System.out.println(max);
            sum += max;
        }
        return sum;
    }

    private static int getBottomToTop(int[][] ints) {

        if (ints.length == 0) {
            return 0;
        }

        if (ints[0].length == 0) {
            return 0;
        }
        int row = ints.length;
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                ints[i][j] += Math.max(ints[i + 1][j], ints[i + 1][j + 1]);
            }
        }
        return ints[0][0];
    }
}
