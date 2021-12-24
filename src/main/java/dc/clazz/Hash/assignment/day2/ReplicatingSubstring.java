package dc.clazz.Hash.assignment.day2;

import java.util.HashMap;
import java.util.Map;

public class ReplicatingSubstring {

    public static void main(String[] args) {
        System.out.println(getSolutionRepString(3, "aabaaaaabb"));
    }
    //
    private static int getSolutionRepString(int A, String B) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < B.length(); i++) {
            if (map.containsKey(B.charAt(i))) {
                map.put(B.charAt(i), map.get(B.charAt(i)) + 1);
            } else {
                map.put(B.charAt(i), 1);
            }
        }
        System.out.println(map.toString());
        if (B.length() % A == 0) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % A != 0) {
                    return 0;
                }
            }
        } else {
             for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (!(entry.getValue() % A == 0)) {
                    return -1;
                }
            }
        }
        return 1;
    }
}
