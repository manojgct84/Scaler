package dc.advance.Trees.BST.class2.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);

        System.out.println(verticalOrderTraversal(root).toString());
    }


    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            if (map.containsKey(pair.getValue())) {
                ArrayList<Integer> l = map.get(pair.getValue());
                l.add(pair.getKey().val);
                map.put(pair.getValue(), l);
            } else {
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(pair.getKey().val);
                map.put(pair.getValue(), lst);
            }
            if (pair.getKey().left != null) {
                q.add(new Pair<>(pair.getKey().left, pair.getValue() + 1));
            }
            if (pair.getKey().right != null) {
                q.add(new Pair<>(pair.getKey().right, pair.getValue() - 1));
            }
            min = Math.min(min, pair.getValue());
            max = Math.max(max, pair.getValue());
        }

        //System.out.println("min " + min  + " max " + max);
        for (int i = min; i < max; i++) {
            res.add(map.get(i));
        }
        return res;
    }

    static class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
