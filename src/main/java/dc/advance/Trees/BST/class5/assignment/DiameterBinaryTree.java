package dc.advance.Trees.BST.class5.assignment;

public class DiameterBinaryTree {
    static int diameter = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(5);
        diameterBinaryTree(root);
        System.out.println("diameter " + diameter);


        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(6);
        diameter = 0;
        diameterBinaryTree(node);
        System.out.println("diameter " + diameter);

        TreeNode node2 = new TreeNode(15);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(2);
        diameter = 0;
        diameterBinaryTree(node2);
        System.out.println("diameter " + diameter);
    }

    public static int diameterBinaryTree(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = diameterBinaryTree(root.left);
        int right = diameterBinaryTree(root.right);
        diameter = Math.max(diameter, (left + right + 2));
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
