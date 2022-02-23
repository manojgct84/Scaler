package dc.advance.Trees.BST.class4.assignment;

import java.util.ArrayList;

public class kthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(9);

        System.out.println(getKthSmallest(root, 3));

        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.right = new TreeNode(10);
        node.right.right = new TreeNode(15);
        node.right.left = new TreeNode(11);

        System.out.println(getKthSmallest(root, 4));

        TreeNode node1 = new TreeNode(1);

        System.out.println(getKthSmallest(node1, 1));
    }

    public static int getKthSmallest(TreeNode root, int B) {
        ArrayList<Integer> in = new ArrayList<>();
        inOrder(root, in);
        return in.get(B - 1);
    }

    private static void inOrder(TreeNode root, ArrayList<Integer> in) {

        if (root == null) {
            return;
        }
        inOrder(root.left, in);
        in.add(root.val);
        inOrder(root.right, in);
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
