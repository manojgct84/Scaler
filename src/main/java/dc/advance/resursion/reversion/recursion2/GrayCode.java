package dc.advance.resursion.reversion.recursion2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://cp-algorithms.com/algebra/gray-code.html#toc-tgt-3
 */
public class GrayCode {

    public static void main(String[] args) {

        System.out.println(new GrayCode().grayCode(2).toString());
        System.out.println(new GrayCode().grayCode(1).toString());
        System.out.println(new GrayCode().grayCode(3).toString());
    }

    public ArrayList<Integer> grayCode(int a) {
        number = 0;
        ArrayList<Integer> res = new ArrayList<>();
        grayCodeRecursion(a, res);
        return res;
    }

    static int number = 0;

    private void grayCodeRecursion(int a, ArrayList<Integer> res) {
        if (a == 0) {
            res.add(number);
            return;
        }
        grayCodeRecursion(a - 1, res);
        number = number ^ (1 << (a - 1));
        grayCodeRecursion(a - 1, res);
    }
}
