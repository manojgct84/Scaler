package dc.Problem.Solving3.Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(5, 20, 50)));
        //System.out.println(ClassMate(5, 20, 50));
    }

    //5, 1, 5
    private static int[] getSolve(int A, int B, int C) {
        int[] res = new int[A];
        res[A - 1] = Integer.MAX_VALUE;
        for (int i = 1; i <= B; i++) {
            for (int j = 1; j <= C - B; j++) {
                List<Integer> d = new ArrayList<>();
                for (int k = 0; k < A; k++) {
                    d.add(i + (j * k));
                }
                if (d.contains(B) && d.contains(C)) {
                    if (res[A - 1] > d.get(A - 1)) {
                        for (int k = 0; k < A; k++) {
                            res[k] = d.get(k);
                        }
                    }
                }
            }
        }
        return res;
    }
}
