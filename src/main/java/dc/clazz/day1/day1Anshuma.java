package dc.clazz.day1;

import java.util.HashMap;
import java.util.Map;

//Facebook on co-efficient score   A- B - how close they are to show the post on the
// A new feed when B post a news. What is degree of separation
public class day1Anshuma {

    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int numberOperation = sc.nextInt();
        System.out.println(codeRating(numberOperation));*/
        String A = "scaler";
        char[] array = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i + 1);
        }
        System.out.println(map.toString());
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < A.length(); j++) {
            int value = map.get(A.charAt(j));
            result.append(A.charAt(j)).append(value);
        }
        System.out.println(result);
    }

    private static String codeRating(int input) {
        if (input < 1000) {
            return "Not a valid input";
        }

        if (input >= 1000 && input < 1400) {
            if (input % 2 == 0) {
                return "newbie".toUpperCase();
            }
            return "newbie";
        }
        if (input >= 1400 && input < 1600) {
            if (input % 2 == 0) {
                return "pupil".toUpperCase();
            }
            return "pupil";
        }
        if (input >= 1600 && input < 1900) {
            if (input % 2 == 0) {
                return "expert".toUpperCase();
            }
            return "expert";
        }
        if (input >= 1900 && input < 2100) {
            if (input % 2 == 0) {
                return "candidate master".toUpperCase();
            }
            return "expert";
        }

        if (input >= 2100 && input % 2 == 0) {

            return "grand master".toUpperCase();
        }
        return "grand master";
    }
}
