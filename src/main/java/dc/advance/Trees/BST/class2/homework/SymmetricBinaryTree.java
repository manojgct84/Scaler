package dc.advance.Trees.BST.class2.homework;

public class SymmetricBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(getIsSymmetric(root));

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);

        System.out.println(getIsSymmetric(node));
    }

    public static int getIsSymmetric(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null || root.right == null && root.left != null) {
            return 0;
        }

        if (root.left != null && root.right != null && root.left.val != root.right.val) {
            return 0;
        }
        return isSymmetric(root.left, root.right) ? 1 : 0;
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left.val != right.val) {
            return false;
        }

        if (left.left == null && right.right != null || left.left != null && right.right == null || left.left != null && left.left.val != right.right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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
