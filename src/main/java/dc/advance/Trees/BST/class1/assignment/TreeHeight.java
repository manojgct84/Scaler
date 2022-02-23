package dc.advance.Trees.BST.class1.assignment;

public class TreeHeight {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);

        System.out.println(getSolve(root));
    }

    public static int getSolve(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = getSolve(root.left);
        int right = getSolve(root.right);

        return Math.max(left, right) + 1;
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
