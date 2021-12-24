package dc.advance.bitManipulation.reversion.assignment2.homework;

import java.util.ArrayList;
import java.util.List;

public class StrangeEquality {

    public static void main(String[] args) {
        System.out.println(solve(5));
        System.out.println(solve(21));
    }

    public static int solve(int A) {
        int original = A;
        int res = 0;
        List<Integer> bits = new ArrayList<>();
        while (A > 0) {
            if (A % 2 == 0) {
                bits.add(1);
            } else {
                bits.add(0);
            }
            A /= 2;
        }
        int j = 0;
        while (j < bits.size()) {
            res += bits.get(j) * Math.pow(2, j);
            j++;
        }
        while (res < original) {
            res += (1 * Math.pow(2, j));
        }
        return res;
    }
}
