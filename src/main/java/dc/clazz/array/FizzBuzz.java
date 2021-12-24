package dc.clazz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFizzBuzz(15)));
    }

    private static String[] getFizzBuzz(int A) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else  if (i % 3 == 0) {
                res.add("Buzz");
            } else  if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        String[] result = new String[res.size()];
        res.toArray(result);
        return result;
    }


}
