package dc.advance.Trie.claas2.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumXOR {

    static int max = Integer.MIN_VALUE;
    static TrieNode root;

    public static void main(String[] args) {
        System.out.println(maximumXOR(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
        System.out.println(maximumXOR(new ArrayList<>(Arrays.asList(5, 17, 100, 11))));
        System.out.println(maximumXOR(new ArrayList<>(Arrays.asList(6, 10, 9, 3, 10, 3, 4, 1, 5, 5, 1, 9, 6, 1, 8, 2, 5, 4, 6, 9, 6))));
    }


    public static int maximumXOR(ArrayList<Integer> A) {
        int maxBits = Integer.MIN_VALUE;
        for (Integer integer : A) {
            maxBits = Math.max(maxBits, integer);
        }

        int noOfBits = Integer.toBinaryString(maxBits).length();
        root = new TrieNode('0');
        for (Integer integer : A) {
            insert(integer, noOfBits);
        }

        for (Integer integer : A) {
            findMax(integer, noOfBits);
        }
        return max;
    }

    private static void findMax(Integer number, int noOfBits) {
        TrieNode curr = root;
        int element = 0;
        for (int i = noOfBits; i > 0; i--) {
            int bit = (1 & (number >> (i - 1)));
            if (curr.children[bit == 0 ? 1 : 0] != null) {
                bit = bit == 0 ? 1 : 0;
                element += bit * Math.pow(2, i - 1);
            } else if (curr.children[bit] != null) {
                element += bit * Math.pow(2, i - 1);
            } else {
                 break;
            }
            curr = curr.children[bit];
        }
        max = Math.max(max, number ^ element);
    }

    public static void insert(int number, int noOfBits) {
        TrieNode curr = root;
        for (int i = noOfBits; i >= 0; i--) {
            int bit = (1 & (number >> (i - 1)));
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode(bit);
            }
            curr = curr.children[bit];
        }
    }

    static class TrieNode {
        int bits;
        TrieNode[] children;

        public TrieNode(int bits) {
            this.bits = bits;
            this.children = new TrieNode[2];
        }
    }
}
