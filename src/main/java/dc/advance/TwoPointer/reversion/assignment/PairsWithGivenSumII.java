package dc.advance.TwoPointer.reversion.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class PairsWithGivenSumII {

    public static void main(String[] args) {
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 1, 1)), 2));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 1)), 2));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(2, 3, 5, 6, 10)), 6));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 2, 6, 6, 7, 9, 9)), 13));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(2, 3, 3, 5, 7, 7, 8, 9, 9, 10,
                10)), 11));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 9
                , 10)), 5));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(2, 2, 3, 4, 4, 5, 6, 7, 10)), 8));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 2, 6, 6, 7, 9, 9)), 13));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(2, 2, 3, 4, 4, 5, 6, 7, 10)), 8));
    }


    static int mod = 1000000007;
    public static int getSolve(ArrayList<Integer> A, int B) {
        int l = 0;
        int r = A.size() - 1;
        int count;
        int sum;
        int res = 0;
        while (l < r) {
            int left = A.get(l);
            int right = A.get(r);
            sum = right + left;
            if (sum == B) {
                if (A.get(l).equals(A.get(r))) {
                    count = (r - l);
                    res = res + count * (count + 1) / 2;
                    break;
                } else {
                    left = A.get(l);
                    right = A.get(r);
                    int cntL = 0;
                    int cntR = 0;
                    while (l < A.size() && left == A.get(l)) {
                        l++;
                        cntL++;
                    }
                    while (r < A.size() && right == A.get(r)) {
                        r--;
                        cntR++;
                    }
                    res = (res % mod + (cntL * cntR) % mod) % mod;
                }
            } else if (sum < B) {
                l++;
            } else {
                r--;
            }
        }
        return res % mod;
    }
}