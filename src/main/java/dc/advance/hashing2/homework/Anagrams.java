package dc.advance.hashing2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(getAnagrams(new String[]{"cat", "dog", "god", "tca"}));
        System.out.println(getAnagrams(new String[]{"abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"}));
    }

    public static ArrayList<ArrayList<Integer>> getAnagrams(final String[] A) {
        Map<String, ArrayList<Integer>> set = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            char[] c = A[i].toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (!set.containsKey(key)) {
                ArrayList<Integer> indx = new ArrayList<>();
                indx.add(i + 1);
                set.put(key, indx);
            } else {
                ArrayList<Integer> index = set.get(key);
                index.add(i + 1);
                set.put(key, index);
            }
        }
        System.out.println(set.toString());
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(set.values());
        return res;
    }
}
