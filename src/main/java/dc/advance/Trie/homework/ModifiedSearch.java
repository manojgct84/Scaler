package dc.advance.Trie.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ModifiedSearch {

    static TrieNode root;

    public static void main(String[] args) {
        System.out.println(modifiedSearch(new ArrayList<>(Arrays.asList("data", "circle",
                "cricket")),
                new ArrayList<>(Arrays.asList("date", "circel", "crikket", "data", "circl"))));
        System.out.println(modifiedSearch(new ArrayList<>(Arrays.asList("hello", "world")),
                new ArrayList<>(Arrays.asList("hella", "pello", "pella"))));
    }

    public static String modifiedSearch(ArrayList<String> A, ArrayList<String> B) {
        root = new TrieNode();
        for (String s : A) {
            trieInsert(s);
        }
        HashSet<String> set = new HashSet<>();
        StringBuilder res = new StringBuilder();
        for (String word : B) {
            set.add(word);
            char[] c = word.toCharArray();
            boolean flag = false;
            for (int j = 0; j < c.length; j++) {
                char old = c[j];
                for (char k = 'a'; k <= 'z'; k++) {
                    c[j] = k;
                    String str = new String(c);
                    if (set.contains(str)) {
                        continue;
                    }
                    flag = trieSearch(str);

                    if (flag) {
                        break;
                    }
                }
                if (!flag) {
                    c[j] = old;
                } else {
                    break;
                }
            }
            if (flag) {
                res.append(1);
            } else {
                res.append(0);
            }
        }
        return res.toString();
    }

    private static boolean trieSearch(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.node.containsKey(word.charAt(i))) {
                return false;
            }
            curr = curr.getNode().get(word.charAt(i));
        }

        return curr.isWordEnd;
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
                curr.freq++;
            }
            if (curr.getNode() != null) {
                curr = curr.getNode().get(value);
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
