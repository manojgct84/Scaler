package dc.advance.bitManipulation.homework;

import java.util.ArrayList;
import java.util.List;

public class StrangeEquality {

    public static void main(String[] args) {
        System.out.println(getSolve(21));
        System.out.println(getSolve(5));
    }

    public static int getSolve(int A) {
        int orig = A;
        List<Integer> bits = new ArrayList<>();
        while (A > 0) {
            if (A % 2 == 0) {
                bits.add(0);
            } else {
                bits.add(1);
            }
            A /= 2;
        }
        System.out.println(bits.toString());

        for (int i = 0; i < bits.size(); i++) {
            if (bits.get(i) == 0) {
                bits.set(i, 1);
            } else {
                bits.set(i, 0);
            }
        }
        int dec = 0;
        int j = 0;
        System.out.println(bits.toString());
        while (j < bits.size()) {
            dec += (int) (bits.get(j) * Math.pow(2, j));
            j++;
        }
        System.out.println("dec " + dec + " j " + j);
        if (dec < orig) {
            dec += (int) (1 * Math.pow(2, j));
        }
        return dec;
    }
}
