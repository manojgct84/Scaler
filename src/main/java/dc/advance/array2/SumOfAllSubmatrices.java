package dc.advance.array2;

public class SumOfAllSubmatrices {
    public static void main(String[] args) {
        System.out.println(getSolution(new int[][]{{1, 1},
                {1, 1}}));
    }

    private static int getSolution(int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                //Contribution of the each element in the sub matrix array
                sum += (i + 1) * (j + 1) * (A.length - i) * (A[0].length - j) * A[i][j];
            }
        }
        return sum;
    }
}
