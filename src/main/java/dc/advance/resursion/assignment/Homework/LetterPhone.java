package dc.advance.resursion.assignment.Homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {
    static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static ArrayList<String> letterCombinations(String A) {
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "0");

        ArrayList<String> res = new ArrayList<>();

        getLetterCombinations(A, "", 0, res);
        return res;
    }

    private static void getLetterCombinations(String digits, String currentString,
        int currentIndex, ArrayList<String> res)
    {
        if (currentIndex == digits.length()) {
            res.add(currentString);
            return;
        }
        String substring = map.get(digits.charAt(currentIndex) - '0');
        for (int i = 0; i < substring.length(); i++) {
            getLetterCombinations(digits, currentString + substring.charAt(i),
                currentIndex + 1, res);
        }
    }
}
