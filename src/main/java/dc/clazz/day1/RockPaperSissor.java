package dc.clazz.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RockPaperSissor {
    static Map<Character, RPS> rps = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Rock Paper Scissor");
        String input = in.nextLine();
        String[] split = input.split(" ");
        String str = Arrays.toString(split);
        char[] ch = str.toCharArray();
        System.out.println("Enter the input for the game - a b or b d");
        int result = 0;
        RPS first = new RPS(ch[1]);
        rps.put(ch[1], first);
        RPS second = new RPS(ch[4]);
        rps.put(ch[4], second);
        RPS third = new RPS(ch[7]);
        rps.put(ch[7], third);
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lst.add(in.nextLine());
        }
        result = compute(lst);
        System.out.println(result);
    }

    private static int compute(List<String> lst) {
        for (String s : lst) {
            char[] c = s.toCharArray();
            RPS first = rps.get(c[0]);
            RPS second = null;
            if (c[1] != 32) {
                second = rps.get(c[1]);
            } else {
                second = rps.get(c[2]);
            }
            if (first.start == 1 || second.end == 1) {
                return 1;
            }
            if (first.start == -1) {
                first.start = 1;
            }

            if (second.end == -1) {
                second.end = 1;
            }
        }
        return 0;
    }
}

class RPS {
    public char value;
    public int start = -1;
    public int end = -1;

    public RPS(char value) {
        this.value = value;
    }
}
