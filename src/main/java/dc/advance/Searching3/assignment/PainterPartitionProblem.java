package dc.advance.Searching3.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class PainterPartitionProblem {

    public static void main(String[] args) {
        System.out.println(getPaint(2, 5, new ArrayList<>(Arrays.asList(1, 10))));
        System.out.println(getPaint(10, 1, new ArrayList<>(Arrays.asList(1, 8, 11, 3))));
    }

    static int mod = 10000003;

    public static int getPaint(int A, int B, ArrayList<Integer> boards) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (Integer board : boards) {
            sum += board;
            max = Math.max(max, board);
        }
        //System.out.println("sum " + sum + " max " + max);
        long low = max;
        long high = sum;
        long res = 0;
        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            if (check(mid, boards, A, B)) {
                res = mid % mod;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ((res % mod) * (B % mod) % mod);
    }

    private static boolean check(long mid, ArrayList<Integer> boards, int a, int b) {
        int painters = 1;
        int time = 0;

        for (Integer board : boards) {
            time += board;
            if (time > mid) {
                time = board;
                painters++;
            }
        }
        return (painters <= a);
    }
}
