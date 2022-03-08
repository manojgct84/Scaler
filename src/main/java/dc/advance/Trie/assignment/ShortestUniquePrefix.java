package dc.advance.Trie.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

    static TrieNode root;

    public static void main(String[] args) {
    //    System.out.print(shortestUniquePrefix(new ArrayList<>(Arrays.asList("zebra", "dog",
    //            "duck", "dove"))));
    //    System.out.print(shortestUniquePrefix(new ArrayList<>(Arrays.asList("apple", "ball",
    //            "cat"))));
    //    System.out.print(shortestUniquePrefix(new ArrayList<>(Arrays.asList("bearcat", "bert"))));
        System.out.print(shortestUniquePrefix(new ArrayList<>(Arrays.asList("lrbbmqb", "cd", "r", "owkk"))));
    }

    public static ArrayList<String> shortestUniquePrefix(ArrayList<String> A) {
        ArrayList<String> res = new ArrayList<>();
        root = new TrieNode();
        for (int i = 0; i < A.size(); i++) {
            trieInsert(A.get(i));
        }

        for (int i = 0; i < A.size(); i++) {
            res.add(trieSearch(A.get(i)));
        }
        return res;
    }

    public static void trieInsert(String word) {
        TrieNode curr = root;
        char[] c = word.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (curr.getNode() != null) {
                TrieNode node = curr.getNode().get(c[i]);
                if (node == null) {
                    curr.getNode().put(c[i], new TrieNode());
                }
            }
            if (curr.getNode() != null) {
                curr = curr.getNode().get(c[i]);
                curr.freq++;
            }
        }
    }

    public static String trieSearch(String word) {
        StringBuilder build = new StringBuilder();
        TrieNode curr = root;
        char[] c = word.toCharArray();
        curr = curr.getNode().get(c[0]);
        if (curr != null && curr.freq == 1) {
            build.append(c[0]);
            return build.toString();
        } else if (curr != null && curr.freq > 1){
            build.append(c[0]);
        }
        for (int i = 1; i < c.length; i++) {
            if (curr != null && curr.getNode() != null) {
                curr = curr.getNode().get(c[i]);
                if (curr.freq == 1) {
                    build.append(c[i]);
                    break;
                } else {
                    build.append(c[i]);
                }
            }
        }
        return build.toString();
    }

    static class TrieNode {
        public int freq;
        public Map<Character, TrieNode> node = new HashMap<>();

        public Map<Character, TrieNode> getNode() {
            return node;
        }
    }
}



