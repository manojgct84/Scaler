package dc.clazz.matrix;

public class MaxRow {

    public static void main(String[] args) {
        System.out.println(getSolution(new int[][]{{0, 0, 0, 0}, {0, 1, 1, 1}}));
    }

    private static int getSolution(int[][] A) {
        int index = -1;
        int max = -1;
        int count;

        for (int i = 0; i < A.length; i++) {
            count = 0;
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    count++;
                }
            }
            if (count != 0 && max < count) {
                index = i;
                max = count;
            }
        }
        return index;
    }
}
