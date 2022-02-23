package dc.advance.Trees.BST.class4.homework;

public class DistanceBetweenNodesBST {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(1);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(11);

        System.out.println(rangeBST(root, 2, 11));

        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left = new TreeNode(1);

        node.right = new TreeNode(9);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(10);

        System.out.println(rangeBST(node, 2, 6));
    }

    public static int rangeBST(TreeNode root, int B, int C) {

        if (B > C) {
            return rangeBST(root, C, B);
        }
        return decideGoingLeftOrRight(root, B, C);
    }

    private static int decideGoingLeftOrRight(TreeNode root, int b, int c) {
        if (root == null) {
            return 0;
        }
        if (root.val > b && root.val > c) {
            return decideGoingLeftOrRight(root.left, b, c);
        } else if (root.val < b && root.val < c) {
            return decideGoingLeftOrRight(root.right, b, c);
        } else if (root.val >= b && root.val <= c) {
            return distanceToRoot(root, b) + distanceToRoot(root, c);
        }
        return 0;
    }

    private static int distanceToRoot(TreeNode root, int val) {
        if (root != null && root.val == val) {
            return 0;
        }

        if (root != null && root.val > val) {
            return 1 + distanceToRoot(root.left, val);
        } else if (root != null && root.val < val) {
            return 1 + distanceToRoot(root.right, val);
        }
        return 0;
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
