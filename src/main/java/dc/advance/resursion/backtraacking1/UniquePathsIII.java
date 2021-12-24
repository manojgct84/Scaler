package dc.advance.resursion.backtraacking1;

public class UniquePathsIII {
    public static void main(String[] args) {
        System.out.println(getSolution(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println(getSolution(new int[][]{{0, 1,}, {2, 0}}));
    }

    public static int getSolution(int[][] A) {
        int startX = 0, startY = 0, totalZeros = 1; // we will step into "2" box that will extract to -. so we start with 1.
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (A[i][j] == 0) {
                    totalZeros++;
                 }
            }
        }
        System.out.println("totalZeros " + totalZeros);
        return dfsRecursion(A, startX, startY, totalZeros);
    }

    private static int dfsRecursion(int[][] matrix, int x, int y, int totalZeros) {

        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] == -1) {
            return 0;
        }

        if (matrix[x][y] == 2) {
            if (totalZeros == 0) {
                return 1;
            }
            return 0;
        }
        matrix[x][y] = -1;
        totalZeros--;
        int pathCount = dfsRecursion(matrix, x + 1, y, totalZeros) +
                dfsRecursion(matrix, x, y + 1, totalZeros) +
                dfsRecursion(matrix, x - 1, y, totalZeros) +
                dfsRecursion(matrix, x, y - 1, totalZeros);
        matrix[x][y] = 0; // after first loop has completed, put back the zeros as we move up.
        //totalZeros++ - doesn't need to be reset as it part of the method parameter.
        return pathCount;
    }
}
