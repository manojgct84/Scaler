package dc.advance.hashing.homework;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("AaaA"));
        System.out.println(lengthOfLongestSubstring("abcabcdbbaeaaaaaae"));
        System.out.println(lengthOfLongestSubstring("dadbc"));
    }

    public static int lengthOfLongestSubstring(String A) {
        Set<Character> set = new HashSet<>();
        char[] c = A.toCharArray();
        int max = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < c.length; i++) {
            if (!set.contains(c[i])) {
                set.add(c[i]);
                max = Math.max(max, set.size());
            } else {
                while (j < i) {
                    if (c[j] == c[i]) {
                        j++;
                        break;
                    }
                    set.remove(c[j]);
                    j++;
                }
            }
        }
        return max;
    }
}
