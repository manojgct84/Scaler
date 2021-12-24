package dc.advance.Sorting3.assignment.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestNumber {


    public static void main(String[] args) {
        System.out.println(largestNumber(new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9))));
        System.out.println(largestNumber(new ArrayList<>(Arrays.asList(2, 3, 9, 0))));
    }

    public static String largestNumber(final List<Integer> A) {

        List<String> str = new ArrayList<>();

        for (Integer integer : A) {
            str.add(String.valueOf(integer));
        }
        //custom sort - 3, 30, 34, 5, 9 == 330 >=303 | 343 >=334 | 35 >=53 | 39 >=93
        str.sort((o1, o2) -> {
            long v1 = Long.parseLong(o1 + o2);
            long v2 = Long.parseLong(o2 + o1);
            if (v1 <= v2) {
                return 1;
            }
            return -1;
        });
        System.out.println(str.toString());
        StringBuilder ssb = new StringBuilder();
        int i = 0;
        while (i < str.size() && !str.get(i).equals("0")) {
            ssb.append(str.get(i));
            i++;
        }
        if (ssb.length()==0) {
            return "0";
        }
        return ssb.toString();
    }
}
