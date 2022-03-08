package dc.advance.Trie.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContactFinder {

    static TrieNode root;

    public static void main(String[] args) {
        System.out.print(contactFinder(new ArrayList<>(Arrays.asList(0, 0, 1, 1)),
                new ArrayList<>(Arrays.asList("hack", "hacker", "hac", "hak"))));
        System.out.print(contactFinder(new ArrayList<>(Arrays.asList(0, 1)),
                new ArrayList<>(Arrays.asList("abcde", "abc"))));
    }

    public static ArrayList<Integer> contactFinder(ArrayList<Integer> A, ArrayList<String> B) {
        ArrayList<Integer> res = new ArrayList<>();
        root = new TrieNode();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                trieInsert(B.get(i));
            } else {
                res.add(searchWord(B.get(i)));
            }
        }
        return res;
    }

    private static Integer searchWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr ==null || curr.getNode() == null) {
                return 0;
            }
            curr = curr.getNode().get(word.charAt(i));
        }
        if (curr == null) {
            return 0;
        }
        return curr.freq;
    }

    public static void trieInsert(String word) {
        TrieNode curr = root;
        char[] c = word.toCharArray();

        for (char value : c) {
            if (curr.getNode() != null) {
                TrieNode node = curr.getNode().get(value);
                if (node == null) {
                    curr.getNode().put(value, new TrieNode());
                }
                //curr.freq++;
            }
            if (curr.getNode() != null) {
                curr = curr.getNode().get(value);
                curr.freq++;
            }
        }
        curr.isWordEnd = true;
    }

    static class TrieNode {
        public int freq;
        public boolean isWordEnd;
        public Map<Character, TrieNode> node = new HashMap<>();

        public Map<Character, TrieNode> getNode() {
            return node;
        }
    }
}
