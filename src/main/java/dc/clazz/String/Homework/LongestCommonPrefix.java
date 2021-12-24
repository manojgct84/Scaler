package dc.clazz.String.Homework;


import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String args[]) {
        String str = "aaaaaaaaaabaaaaaaaaa";
        System.out.println(getSolutionString(new String[]{"abcdefgh", "aefghijk", "abcefgh"}));
    }

    private static String getSolutionString(String[] strings) {
        if (strings.length == 0 || strings.length == 1) {
            return Arrays.toString(strings);
        }
        String pre = strings[0];
        int i = 1;
        while (i < strings.length) {
            while (strings[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        return pre;
    }
}
