package dc.advance.Trie.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AutoComplete {
    static TrieNode root;

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner in = new Scanner(System.in);
        int testCase = Integer.parseInt(in.nextLine());
        Pair[] pair;
        for (int i = 0; i < testCase; i++) {
            in.nextLine();
            String word = in.nextLine();
            String weight = in.nextLine();
            String[] search = in.nextLine().split(" ");
            pair = generatePair(word.split(" "), weight.split(" "));
            root = new TrieNode();
            Arrays.sort(pair, new ComparatorAutoComp());
            insert(pair);
            search(search, pair);
        }
    }

    private static void search(String[] search, Pair[] pair) {
        for (String s : search) {
            TrieNode curr = root;
            boolean found = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (curr.getChild() == null || curr.getChild().get(c) == null) {
                    found = false;
                    break;
                } else {
                    curr = curr.getChild().get(c);
                }
            }
            if (!found) {
                System.out.print(-1 + "");
            } else {
                String[] word = curr.index.stream().map(k -> pair[k].word).toArray(String[]::new);
                System.out.print(String.join(" ", word) + " ");
            }
        }
    }

    private static void insert(final Pair[] pair) {
        for (int i = 0; i < pair.length; i++) {
            TrieNode curr = root;
            Pair p = pair[i];
            char[] c = p.word.toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (curr.getChild() != null) {
                    TrieNode node = curr.getChild().get(c[j]);
                    if (node == null) {
                        curr.getChild().put(c[j], new TrieNode());
                    }
                    if (curr.getChild() != null &&
                        curr.getChild().get(c[j]).index.size() < 5) {
                        curr.getChild().get(c[j]).index.add(i);
                    }
                    if (j == c.length - 1) {
                        curr.getChild().get(c[j]).isEnded = true;
                    }
                    curr = curr.getChild().get(c[j]);
                }
            }
        }
    }

    private static Pair[] generatePair(String[] words, String[] weight) {
        Pair[] pair = new Pair[words.length];
        for (int i = 0; i < words.length; i++) {
            pair[i] = new Pair(words[i], Integer.valueOf(weight[i]));
        }
        return pair;
    }


    static class Pair {
        protected String word;
        protected int weight;

        public Pair(String word, int weight) {
            this.word = word;
            this.weight = weight;
        }
    }

    static class TrieNode {
        public boolean isEnded;
        public ArrayList<Integer> index = new ArrayList<>();
        public Map<Character, TrieNode> child = new HashMap<>();

        public Map<Character, TrieNode> getChild() {
            return child;
        }
    }

    static class ComparatorAutoComp implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o2.weight - o1.weight;
        }
    }
}
