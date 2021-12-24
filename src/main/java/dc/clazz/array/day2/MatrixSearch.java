package dc.clazz.array.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class MatrixSearch {

    public static void main(String[] args) {
        /*System.out.println(getSolution(new int[][]{{7, 8, 8, 8},
                {7, 8, 9, 8},
                {7, 9, 9, 10}}, 9));*/
        System.out.println(getSolution(new int[][]{{0}}, 1));
    }

    private static int getSolution(int[][] A, int B) {

        if (A.length == 0) {
            return -1;
        }

        int i = 0;
        int j = A[0].length - 1;
        while (i < A.length && j >= 0) {

            if (A[i][j] < B) {

                i++;
            } else if (A[i][j] > B) {
                //3 > 2
                j--;
            } else {
                return bfsSearch(i, j, B, A);
            }
        }
        return -1;
    }

    private static int bfsSearch(int row, int col, int B, int[][] A) {

        Queue<Pair> q = new LinkedBlockingDeque<>();
        Pair node = new Pair(row, col - 1);
        q.add(node);
        List<Pair> visited = new ArrayList<>();
        visited.add(new Pair(row, col));
        while (!q.isEmpty()) {
            Pair pair = q.remove();
            int i = pair.getKey();
            int j = pair.getValue();
            if (i == 0 && j >= 0 && A[i][j] == B) {
                visited.add(new Pair(i, j));
                Pair colMove = new Pair(i, j - 1);
                q.add(colMove);
            } else if (i <= A.length - 1 && j <= A[0].length - 1 && i >= 0 && j >= 0) {
                if (A[i][j] == B) {
                    visited.add(new Pair(i, j));
                    Pair rowMove = new Pair(i, j - 1);
                    Pair colMove = new Pair(i - 1, j);
                    q.add(rowMove);
                    q.add(colMove);
                }
            } else {
                Pair kv = visited.get(visited.size() - 1);
                int k = kv.getKey() + 1;
                int v = kv.getValue() + 1;
                return k * 1009 + v;
            }

        }
        Pair kv = visited.get(visited.size() - 1);
        int k = kv.getKey() + 1;
        int v = kv.getValue() + 1;
        return k * 1009 + v;
    }
}

class Pair {
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
