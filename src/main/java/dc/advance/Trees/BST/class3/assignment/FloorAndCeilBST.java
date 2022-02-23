package dc.advance.Trees.BST.class3.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class FloorAndCeilBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(19);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(100);

        System.out.println(floorAndCeil(root, new ArrayList<>(Arrays.asList(1, 11))).toString());

        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(4);
        node.right = new TreeNode(15);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(8);

        System.out.println(floorAndCeil(node, new ArrayList<>(Arrays.asList(4, 19))).toString());

    }

    public static ArrayList<ArrayList<Integer>> floorAndCeil(TreeNode root, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);
        int min;
        int max;
        for (Integer integer : B) {
            Pair<Integer, Integer> pair = getMinMaxValueInOrder(integer,
                    new Pair<>(Integer.MIN_VALUE,
                            Integer.MAX_VALUE), inOrder);
            min = pair.min == Integer.MIN_VALUE ? -1 : pair.min;
            max = pair.max == Integer.MAX_VALUE ? -1 : pair.max;
            ArrayList<Integer> lst = new ArrayList<>();
            lst.add(min);
            lst.add(max);
            res.add(lst);
        }
        int j = 0;

        /*while (j < B.size()) {
            TreeNode curr = root;
            // Pair<Integer, Integer> pair = new Pair<>(Integer.MIN_VALUE, Integer.MAX_VALUE);
            Pair<Integer, Integer> pair = getMinMaxValue(curr, B.get(j), new Pair<>(Integer.MIN_VALUE, Integer.MAX_VALUE));
            min = pair.min == Integer.MIN_VALUE ? -1 : pair.min;
            max = pair.max == Integer.MAX_VALUE ? -1 : pair.max;
            ArrayList<Integer> lst = new ArrayList<>();
            lst.add(min);
            lst.add(max);
            res.add(lst);
            j++;
        }*/
        return res;
    }

    private static Pair<Integer, Integer> getMinMaxValueInOrder(Integer val,
        Pair<Integer, Integer> pair, ArrayList<Integer> inOrder)
    {

        for (Integer integer : inOrder) {
            if (integer <= val) {
                pair.min = Math.max(pair.min, integer);
            }

            if (integer >= val) {
                pair.max = Math.min(pair.max, integer);
            }
        }
        return pair;
    }

    private static Pair<Integer, Integer>
    getMinMaxValue(TreeNode curr, Integer value, Pair<Integer, Integer> pair) {
        if (curr == null) {
            return null;
        }
        if (curr.val <= value) {
            pair.min = Math.max(pair.min, curr.val);
        }

        if (curr.val >= value) {
            pair.max = Math.min(pair.max, curr.val);
        }
        if (curr.val > value) {
            getMinMaxValue(curr.left, value, pair);
        }
        getMinMaxValue(curr.right, value, pair);

        return pair;
    }

    private static void inOrder(TreeNode root, ArrayList<Integer> inOrder) {

        if (root == null) {
            return;
        }
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }

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


    static class Pair<K, V> {
        K min;
        V max;

        Pair(K key, V value) {
            this.min = key;
            this.max = value;
        }
    }
}
