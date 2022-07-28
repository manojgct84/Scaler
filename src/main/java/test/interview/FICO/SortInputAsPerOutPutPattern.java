package test.interview.FICO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortInputAsPerOutPutPattern {

    public static void main(String[] args) {
        System.out.println(sortInputAsPerOutPutPattern(new int[]{3, 456, 23190, 87, 9}));
        System.out.println(sortInputAsPerOutPutPattern(new int[]{135, 25, 789, 456, 89, 98812}));
        System.out.println(sortInputAsPerOutPutPattern(new int[]{35699, 36, 13, 9, 8}));
    }

    private static List<String> sortInputAsPerOutPutPattern(int[] A) {

        String[] str = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            str[i] = String.valueOf(A[i]);
        }
        Arrays.sort(str);
        List<String> list = Arrays.asList(str);
        Collections.reverse(list);
        return list;
    }

}
