package dc.advance.array1.Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3, 4, 5, 6})));
    }

    public static int[] plusOne(int[] A) {
        ArrayList<Integer> res = new ArrayList<>();
        int carry = 0;

        for (int i : A) {
            res.add(i);
        }

        for (int i = res.size() - 1; i >= 0; i--) {
            if (res.get(i) == 9) {
                res.set(i, 0);
                carry = 1;
            } else {
                res.set(i, res.get(i) + 1);
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            res.add(0, 1);
        }

        while (res.size() > 0 && res.get(0) == 0) {
            res.remove(0);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }


}
