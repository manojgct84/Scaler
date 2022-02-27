package dc.advance.Trees.BST.class6.homework;

import java.util.HashSet;

public class EqualTreePartition {
    static HashSet<Integer> set;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(equalTreePartition(root));

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(10);
        node.right.left = new TreeNode(20);
        node.right.right = new TreeNode(2);

        System.out.println(equalTreePartition(node));
    }

    public static int equalTreePartition(TreeNode root) {
        set = new HashSet<>();
        int sum = findSum(root);
        System.out.print(set.toString());
        if (sum % 2 != 0) {
            return 0;
        }

        if (set.contains(sum / 2)) {
            return 1;
        }
        return 0;
    }

    private static int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int l = findSum(root.left);
        int r = findSum(root.right);
        set.add(val + l + r);
        return val + l + r;
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
