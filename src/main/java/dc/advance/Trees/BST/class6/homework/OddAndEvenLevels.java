package dc.advance.Trees.BST.class6.homework;

import java.util.LinkedList;
import java.util.Queue;

public class OddAndEvenLevels {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(oddAndEvenSum(root));

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(10);

        System.out.println(oddAndEvenSum(node));
    }

    public static int oddAndEvenSum(TreeNode root) {
        Pair pair = new Pair(0, 0);
        findEvenOddLevelSum(root, pair);
        //findEvenAndOddSum(root, pair);
        //return pair.even > pair.odd ? pair.even - pair.odd : pair.odd - pair.even;
        return pair.odd - pair.even;
    }

    private static void findEvenOddLevelSum(TreeNode root, Pair pair) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        while (!q.isEmpty() && q.size() > 1) {
            TreeNode node = q.poll();
            if (node == null) {
                q.add(null);
                level++;
                continue;
            }
            if (level % 2 == 0) {
                pair.even += node.val;
            } else {
                pair.odd += node.val;
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    private static void findEvenAndOddSum(TreeNode root, Pair pair) {
        if (root == null) {
            return;
        }

        if (root.val % 2 == 0) {
            pair.even += root.val;
        } else {
            pair.odd += root.val;
        }
        findEvenAndOddSum(root.left, pair);
        findEvenAndOddSum(root.right, pair);
    }

    static class Pair {
        int odd;
        int even;

        Pair(int even, int odd) {
            this.even = even;
            this.odd = odd;
        }
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
