package dc.advance.Trees.BST.class4.assignment;

import java.util.Arrays;

public class RecoverBinarySearchTree {

    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        System.out.println(Arrays.toString(recoverTree(root)));

        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(1);

        System.out.println(Arrays.toString(recoverTree(node)));
    }

    public static int[] recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = null;
        inOderSwap(root);
        return new int[]{second.val, first.val};
    }

    private static void inOderSwap(TreeNode root) {
        if (root == null) {
            return;
        }
        inOderSwap(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inOderSwap(root.right);
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
}
