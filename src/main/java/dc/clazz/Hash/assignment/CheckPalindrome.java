package dc.clazz.Hash.assignment;

import java.util.HashMap;
import java.util.Map;

public class CheckPalindrome {

    public static void main(String[] args) {
        System.out.println(getSolution("aabbaa"));
    }

    public static int getSolution(String A) {
        if (A.length() == 1 || A.length() == 0) {
            return 1;
        }

        if (A.charAt(0) == A.charAt(A.length() - 1)) {
            return getSolution(A.substring(1, A.length() - 1));
        }
        return 0;
    }

    public static int getSolutionReArrange(String A) {
        if (A.length() == 1 || A.length() == 0) {
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
            } else {
                map.put(A.charAt(i), 1);
            }
        }

        if (A.length() % 2 == 0) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    return 0;
                }
            }
        } else {
            int countOdd = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (!(entry.getValue() % 2 == 0)) {
                    countOdd++;
                }
            }
            if (countOdd > 1) {
                return 0;
            }
        }
        return 1;
    }
}
