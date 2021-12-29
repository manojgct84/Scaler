package dc.advance.TwoPointer.reversion.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PairsWithGivenDifference {
    public static void main(String[] args) {
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 5, 3, 4, 2)), 2));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)),
                0));
    }

    public static int getSolve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int l = 0;
        int r = 1;
        int res = 0;
        while (r < A.size()) {
            if (l == r) {
                r++;
            } else {
                int left = A.get(l);
                int right = A.get(r);
                if ((right - left) == B) {
                    res++;
                    while (l < A.size() && left == A.get(l)) {
                        l++;
                    }
                    while (r < A.size() && right == A.get(r)) {
                        r++;
                    }
                } else if ((right - left) < B) {
                    r++;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
