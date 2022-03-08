package dc.advance.Trie.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class SpellingChecker {

    public static void main(String[] args) {
        System.out.print(spellingChecker(new ArrayList<>(Arrays.asList("hat", "cat", "rat")),
                new ArrayList<>(Arrays.asList("cat", "ball"))));
        System.out.print(spellingChecker(new ArrayList<>(Arrays.asList("tape", "bcci")),
                new ArrayList<>(Arrays.asList("table", "cci"))));
    }

    public static ArrayList<Integer> spellingChecker(ArrayList<String> A, ArrayList<String> B) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < B.size()) {
            if (A.contains(B.get(i))) {
                res.add(1);
            } else {
                res.add(0);
            }
        }
        return res;
    }
}
