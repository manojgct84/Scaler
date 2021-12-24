package dc.clazz.matrix;

import java.util.ArrayList;

public class AntiDiagonals {

    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(getSolution(new int[][]{{3, 7, 7, 1}, {8, 4, 15, 1}, {7, ,8,8, 9}})));
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        ArrayList<Integer> col0 = new ArrayList<>();
        col0.add(1);
        col0.add(2);
        col0.add(3);
        //col0.add(1);
        lst.add(col0);
        ArrayList<Integer> col1 = new ArrayList<>();
        col1.add(4);
        col1.add(5);
        col1.add(6);
        //col1.add(1);
        lst.add(col1);
        ArrayList<Integer> col2 = new ArrayList<>();
        col2.add(7);
        col2.add(8);
        col2.add(9);
        //col2.add(9);
        lst.add(col2);
        System.out.println(scalerDiagonal(lst).toString());

    }
    //This is working
    public static ArrayList<ArrayList<Integer>> scalerDiagonal(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2 * l - 1; ++i) {
            int offset = i < l ? 0 : i - l + 1;
            ArrayList<Integer> row = new ArrayList<>();
            int k=0;
            for (int j = offset; j <= i - offset; ++j) {
                row.add(A.get(j).get(i - j));
                k++;
            }
            for(int j = k; j< l ;j++){
                row.add(0);
            }
            res.add(row);
        }
        return res;
    }

    private static int[][] getSolution(int[][] A) {
        //List<List<Integer>> res = new ArrayList<>();
        int[][] res = new int[2 * A.length - 1][A[0].length];
        //Triangle
        for (int c = 0; c < A[0].length; c++) {
            int r = 0;
            int col = c;
            int m = 0;
            while (col >= 0) {
                res[c][m] = A[r][col];
                r++;
                col--;
                m++;
            }
        }
        int i = res.length - A.length + 1;
        for (int r = 1; r < A.length; r++) {
            int row = r;
            int c = A[0].length - 1;
            int col = 0;
            while (row < A.length) {
                res[i][col] = A[row][c];
                row++;
                c--;
                col++;
            }
            i += 1;
        }

        return res;
    }
    //This is working
    public static ArrayList<ArrayList<Integer>> getSolutionList(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        //column level
        for (int c = 0; c < A.get(0).size(); c++) {
            int r = 0;
            int col = c;
            ArrayList<Integer> first = new ArrayList<>();
            while (col >= 0) {
                first.add(A.get(r).get(col));
                r++;
                col--;
            }
            //fill in the zero's for missing values
            if (first.size() < A.get(0).size()) {
                int i = first.size();
                while (i < A.get(0).size()) {
                    first.add(0);
                    i++;
                }
            }
            lst.add(first);
        }
        //second half to fill in the row level
        for (int r = 1; r < A.size(); r++) {
            int row = r;
            int col = A.get(0).size();
            ArrayList<Integer> second = new ArrayList<>();
            while (row < A.size()) {
                second.add(A.get(row).get(col));
                row++;
                col--;
            }
            //fill in the zero's for missing values
            if (second.size() < A.get(0).size()) {
                int i = second.size();
                while (i < A.get(0).size()) {
                    second.add(0);
                    i++;
                }
            }
            lst.add(second);
        }
        Integer[][] array = lst.stream().map(l -> l.toArray(new Integer[0])).toArray(Integer[][]::new);
        return lst;
    }
}
