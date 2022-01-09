package dc.advance.Sorting2.reversion.homework.customSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a array A of non negative integers, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
//TC : nlogn
public class LargestNumber {

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{0, 0, 0, 0, 0}));
    }

    public static String largestNumber(final int[] A) {
        List<String> res = new ArrayList<>();
        for (int a : A) {
            res.add(String.valueOf(a));
        }
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                long index1 = Long.parseLong(o1 + o2);
                long index2 = Long.parseLong(o2 + o1);
                if (index1 <= index2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < res.size()) {
            if (!res.get(i).equals("0")) {
                str.append(res.get(i));
            } else if (str.length() != 0) {
                str.append(res.get(i));
            }
            i++;
        }
        if (str.length() == 0) {
            return "0";
        }
        return str.toString();
    }
}
