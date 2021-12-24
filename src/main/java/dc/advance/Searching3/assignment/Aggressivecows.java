package dc.advance.Searching3.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Aggressivecows {

    public static void main(String[] args) {
         System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 3));
          System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 2)), 2));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(5, 17, 100, 11)), 2));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(82, 61, 38, 88, 12, 7, 6, 12, 48,
                8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95)), 8));
    }

    public static int getSolve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        if (A.size() <= 1) {
            return 0;
        }

        if (B <= 1) {
            return 1;
        }

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (Integer integer : A) {
            high = Math.max(high, integer);
            low = Math.min(low, integer);
        }
        int l = low;
        int r = high;
        int res = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (check(mid, A, B)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private static boolean check(int minDist, ArrayList<Integer> stall, int cows) {

        int recent_placed = stall.get(0);
        int cows_placed = 1;

        for (int i = 1; i < stall.size(); i++) {
            if (stall.get(i) - recent_placed >= minDist) {
                recent_placed = stall.get(i);
                cows_placed++;
            }
        }
        return (cows_placed >= cows);
    }
}
