package dc.clazz.String.Assignment;

import java.util.Arrays;

public class ZigZagConversion {


    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern
     * row
     * 0=  P   I   N
     * 1=  A L S I G
     * 2=  Y A H R
     * 3=  P   I
     * Output : PINALSIGYAHRPI
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(zigZagConversion("PAYPALISHIRING", 4));
    }

    private static String zigZagConversion(final String str, final int rows) {
        char[] chars = str.toCharArray();
        int index = 0;

        StringBuilder[] res = new StringBuilder[rows];

        for (int i = 0; i < rows; i++) {
            res[i] = new StringBuilder();
        }

        while (index < chars.length) {
            for (int i = 0; i < rows && index < chars.length; i++) {
                res[i].append(chars[index++]);
            }
            System.out.println(Arrays.toString(res));

            for (int i = rows - 2; i > 0 && index < chars.length; i--) {
                res[i].append(chars[index++]);
            }
            System.out.println(Arrays.toString(res));
        }
        StringBuilder result = res[0];
        for (int i = 1; i < rows; i++) {
            result.append(res[i].toString());
        }
        return result.toString();
    }

}
