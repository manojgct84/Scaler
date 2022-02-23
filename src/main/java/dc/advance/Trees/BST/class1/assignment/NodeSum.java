package dc.advance.Trees.BST.class1.assignment;

public class NodeSum {
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

        return maxNodeInTree(root);
    }

    private static int maxNodeInTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int left = maxNodeInTree(root.left);
        int right = maxNodeInTree(root.right);
        return val + left + right;
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
