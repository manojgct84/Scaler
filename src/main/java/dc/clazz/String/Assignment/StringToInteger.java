package dc.clazz.String.Assignment;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(stringToInteger("4193 with words"));
        System.out.println(stringToInteger("4193"));
        System.out.println(stringToInteger("words and 987"));
        System.out.println(stringToInteger("-91283472332"));
        System.out.println(stringToInteger("-42"));
    }

    private static int stringToInteger(String str) {
        String[] st = str.split(" ");
        // System.out.println(Arrays.toString(st));
        int val;
        try {
            if (st[0].charAt(0) == '-') {
                long longVal = Long.parseLong(st[0].substring(1)) * -1;
                if (longVal < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else {
                    val = Integer.parseInt(st[0].substring(1));
                    return -1 * val;
                }
            } else {
                long longVal = Long.parseLong(st[0]);
                if (longVal > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
            return Integer.parseInt(st[0]);

        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
