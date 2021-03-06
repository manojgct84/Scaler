package dc.advance.Trees.BST.class2.homework;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);

        System.out.println(getInvertTree(root));

        TreeNode node = new TreeNode(26);
        node.left = new TreeNode(10);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(3);

        System.out.println(getInvertTree(node));
    }


    public static TreeNode getInvertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.right = getInvertTree(root.left);
        node.left = getInvertTree(root.right);

        return node;
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
