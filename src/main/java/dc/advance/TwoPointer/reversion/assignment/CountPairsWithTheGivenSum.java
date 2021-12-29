package dc.advance.TwoPointer.reversion.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class CountPairsWithTheGivenSum {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 5));
        System.out.println(solve(new ArrayList<>(Arrays.asList(5, 10, 20, 100, 105)), 110));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int l = 0;
        int r = A.size() - 1;
        int count = 0;
        int sum;
        while (l < r) {
            sum = A.get(l) + A.get(r);
            if (sum == B) {
                count++;
                l++;
                r--;
            } else if (sum > B) {
                r--;
            } else {
                l++;
            }
        }
        return count;
    }

}
