package dc.advance.hashing.homework;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

    public static void main(String[] args) {
        System.out.println(getColorful(23));
        System.out.println(getColorful(236));
    }

    public static int getColorful(int A) {

        String str = String.valueOf(A);
        char[] c = str.toCharArray();

        Set<Long> set = new HashSet<>();


        for (int i = 0; i < c.length; i++) {
            if (set.contains((long) c[i] - 48)) {
                return 1;
            }
            set.add((long) ((int) c[i] - 48));
            int k = i;
            while (k < c.length - 1) {
                set.add((long) ((c[k] - 48) * (c[k + 1] - 48)));
                k++;
            }
        }
        return 0;
    }
}
