package dc.advance.Trees.BST.class2.homework;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(getIsBalanced(root));

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);

        System.out.println(getIsBalanced(node));
    }

    private static int getIsBalanced(TreeNode node) {
        return isBalanced(node);
    }

    private static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        return Math.max(left, right) + 1;
    }

    //As max height of the tree.
    public static int isBalanced(TreeNode root) {

        if (root == null) {
            return 1;
        }

        int l = treeHeight(root.left);
        int r = treeHeight(root.right);

        if (Math.abs(l - r) > 1) {
            return 0;
        }
        return (isBalanced(root.left) & isBalanced(root.right)) == 1 ? 1 : 0;
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
