package dc.advance.mod.assignment.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowersOf3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(13)));
        System.out.println(Arrays.toString(getSolve(3)));
        System.out.println(Arrays.toString(getSolve(411)));
    }

    public static int[] getSolve(int A) {

        List<Integer> binary = new ArrayList<>();
        while (A > 0) {
            int r = A % 3;
            binary.add(r);
            A /= 3;
        }

        System.out.println(binary.toString());
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < binary.size(); i++) {
            if (binary.get(i) != 0) {
                while (j < binary.get(i)) { //  01011 = 1*2^0 + 1*2^1 + 1*2^3
                    res.add((int) Math.pow(3, i));
                    j++;
                }
                j =0;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}

