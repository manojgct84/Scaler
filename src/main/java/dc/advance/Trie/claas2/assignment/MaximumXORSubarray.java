package dc.advance.Trie.claas2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumXORSubarray {
    static TrieNode root;

    public static void main(String[] args) {
        System.out.println(maximumXORSubarray(new ArrayList<>(Arrays.asList(1, 4, 3))));
        System.out.println(maximumXORSubarray(new ArrayList<>(Collections.singletonList(8))));
        System.out.println(maximumXORSubarray(new ArrayList<>(Arrays.asList(33, 29, 18))));
    }

    public static ArrayList<Integer> maximumXORSubarray(ArrayList<Integer> A) {
        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        for (int i = 0; i < A.size(); i++) {
            prefix.add(prefix.get(i) ^ A.get(i));
        }
        ArrayList<Integer> res = new ArrayList<>();
        root = new TrieNode();
        int xor = 0;
        insert(prefix.get(0), 0);
        for (int i = 1; i < prefix.size(); i++) {
            Pair pair = findXOR(prefix.get(i));
            int newXor = pair.number ^ prefix.get(i);
            if (newXor > xor) {
                res = new ArrayList<>();
                res.add(pair.idx + 1);
                res.add(i);
                xor = pair.number ^ prefix.get(i);
            } else if (newXor == xor) {
                int oldl = res.get(1) - res.get(0);
                int newl = i - (pair.idx + 1);
                if (newl < oldl) {
                    res = new ArrayList<>();
                    res.add(pair.idx + 1);
                    res.add(i);
                    xor = pair.number ^ prefix.get(i);
                } else if (newl == oldl && i < res.get(0)) {
                    res = new ArrayList<>();
                    res.add(pair.idx + 1);
                    res.add(i);
                    xor = pair.number ^ prefix.get(i);
                }
            }
            insert(prefix.get(i), i);
        }
        return res;
    }

    private static Pair findXOR(int n) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = n & (1 << i);
            if (bit > 0) {
                if (curr.zero == null) {
                    curr = curr.one;
                } else {
                    curr = curr.zero;
                }
            } else {
                if (curr.one == null) {
                    curr = curr.zero;
                } else {
                    curr = curr.one;
                }
            }
        }
        return curr.pair;
    }

    private static void insert(int n, int idx) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = n & (1 << i);
            if (bit > 0) {
                if (curr.one == null) {
                    curr.one = new TrieNode();
                }
                curr = curr.one;
            } else {
                if (curr.zero == null) {
                    curr.zero = new TrieNode();
                }
                curr = curr.zero;
            }
        }
        curr.pair = new Pair(n, idx);
    }

    static class TrieNode {
        TrieNode zero;
        TrieNode one;
        Pair pair;
    }

    static class Pair {
        int number;
        int idx;

        public Pair(int number, int i) {
            this.number = number;
            this.idx = i;
        }
    }
}



