package test.interview.walmart;

import java.util.HashMap;
import java.util.Map;

public class Anagram
{
    public static void main(String args[] ) throws Exception {
        // Anagram - Nagaram - Magaran - 3 As, 1 N, 1M, 1R and 1G
        String one = "anagram";
        String two = "zagaran";
        // One - Neo
        System.out.print(getAnagram(one,two));
    }

    private static boolean getAnagram(String str1, String str2){

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        if (str1.length() !=str2.length()){
            return false;
        }

        char[] chr1 = str1.toCharArray();
        char[] chr2 = str2.toCharArray();
//O(n)
        for (int i = 0; i < chr1.length; i++) {
            if (map1.containsKey(chr1[i])) {
                map1.put(chr1[i], map1.get(chr1[i]) + 1);
            }
            else {
                map1.put(chr1[i], 1);
            }

            if (map2.containsKey(chr2[i])) {
                map2.put(chr2[i], map2.get(chr2[i]) + 1);
            }
            else {
                map2.put(chr2[i], 1);
            }
        }

        System.out.println(map1.equals(map2));

        //(m+n)
        for (char c : chr2) {
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) - 1);
                if (map1.get(c) <= 0) {
                    map1.remove(c);
                }
            }
            else {
                return false;
            }
        }
        return map1.size() == 0;
    }
}
