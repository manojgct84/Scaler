package dc.clazz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class AddOneToNumber {
    static Vector<int[]> STATIC_ROW = new Vector<>();
    static int[] col = new int[4];
    static int[] col3 = new int[4];
    static Vector<Vector> row = new Vector<>();
    static Vector<Integer> col1 = new Vector<>();
    static Vector<Integer> col2 = new Vector<>();

    public static void main(String[] args) {
        col1.add(1);
        col1.add(2);
        row.add(col1);
        col2.add(4);
        col2.add(5);
        col2.add(6);
        row.add(col2);
        //System.out.println(Arrays.toString(getSolve(new int[]{0, 6, 0, 6, 4, 8, 8, 1})));

        System.out.println(row.toString());
        System.out.println(row.get(1).get(2));
        System.out.println(STATIC_ROW.get(1)[0]);
        col[0] = 1;
        col[1] = 2;
        col[2] = 3;
        col[3] = 4;
        STATIC_ROW.add(col);
        col3[0] = 5;
        col3[1] = 6;
        col3[2] = 7;
        col3[3] = 8;
        STATIC_ROW.add(col3);
        System.out.println(Arrays.toString(STATIC_ROW.toArray()));
        System.out.println(STATIC_ROW.get(1)[0]);
    }

    private static int[] getSolve(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int j : A) {
            res.add(j);
        }
        int carry = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            int digits = res.get(i);
            if (digits == 9) {
                res.set(i, 0);
                carry = 1;
            } else {
                res.set(i, digits + 1);
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
