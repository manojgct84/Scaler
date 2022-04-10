package dc.advance.DynamicPrograming.class4;

import java.util.ArrayList;
import java.util.List;

public class WaysToSendTheSignal {

    public static void main(String[] args) {
        System.out.println(waysToSendTheSignal(2));
        System.out.println(waysToSendTheSignal(3));
        System.out.println(waysToSendTheSignal(6));
        System.out.println(waysToSendTheSignal(5));

    }


    public static int waysToSendTheSignal(int A) {
        int mod = 100000007;
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);
        dp.add(3);
        dp.add(5);

        if (A == 0) {
            return 0;
        }
        if (A == 1) {
            return 1;
        }
        if (A == 2) {
            return 3;
        }
        if (A == 3) {
            return 5;
        }
        for (int i = 4; i <= A; i++) {
            dp.add((dp.get(i - 1) % mod + dp.get(i - 2) % mod) % mod);
        }
        return dp.get(A);
    }
}
