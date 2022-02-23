package dc.advance.Trees.BST.class2.homework;


/**
 * Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes
 * present in its left subtree and right subtree.
 *
 * An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node
 * is also considered as SumTree.
 */
public class SumBinaryTreeOrNot {
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

        TreeNode node = new TreeNode(26);
        node.left = new TreeNode(10);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(3);

        System.out.println(getSolve(node));
    }

    //This is similar to sum of all nodes - NodeSum

    public static int getSolve(TreeNode root) {

        return sumOfBinaryTreeOrNot(root) == -1 ? 0 : 1;
    }

    private static int sumOfBinaryTreeOrNot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int l = getSolve(root.left);
        int r = getSolve(root.right);
        if ((l + r ) == root.val) {
            return 2 * root.val;
        }
        return -1;
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
