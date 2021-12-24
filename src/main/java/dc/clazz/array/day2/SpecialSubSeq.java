package dc.clazz.array.day2;

public class SpecialSubSeq {

    public static void main(String[] args) {
        System.out.println(getSolve("AGB"));
    }

    private static int getSolve(String str) {

        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();

        int res = 0;
        int g_count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {

            if (chars[i] == 'G') {
                g_count++;
            } else if (chars[i] == 'A') {
                res += g_count;
            }
        }
        return res % (1000000000 + 7);
    }
}