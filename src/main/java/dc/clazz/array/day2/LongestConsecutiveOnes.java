package dc.clazz.array.day2;

public class LongestConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(getSolve("111000")); /// boundry conditions
        System.out.println(getSolve("111011101"));
        System.out.println(getSolve("010100110101"));
        System.out.println(getSolve("1101001100101110"));
        System.out.println(getSolve("01")); // boundry conditions
        System.out.println(getSolve("110011"));


    }

    private static int getSolve(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            if (chars[0] - '0' == 1) {
                return 1;
            }
            if (chars[0] - '0' == 0) {
                return 0;
            }
        }

        int l = 0;
        int r = 0;
        int max = 0;
        int onesCount = 0;
        int zeros = 0;

        for (char aChar : chars) {
            if (aChar - '0' == 1) {
                onesCount++;
            }
        }
        while (r < chars.length) {
            if (chars[r] - '0' == 0) {
                zeros++;
            }
            if (zeros > 1) {
                while (l < chars.length && chars[l] - '0' != 0) {
                    l++;
                }
                l++;
                zeros--;
            }
            if ((r - l + 1 - zeros) == onesCount) {
                return onesCount;
            } else {
                max = Math.max(max, r - l + 1);
            }
            r++;
        }
        return max;
    }


}
