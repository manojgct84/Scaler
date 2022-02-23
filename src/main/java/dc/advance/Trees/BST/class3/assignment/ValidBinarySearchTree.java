package dc.advance.Trees.BST.class3.assignment;

public class ValidBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);

        System.out.println(isValidBST(root));
        System.out.println(isValidBSTInOrder(root,null));

        TreeNode node = new TreeNode(26);
        node.left = new TreeNode(10);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(3);

        System.out.println(isValidBST(node));
        System.out.println(isValidBSTInOrder(node,null));
    }

    public static int isValidBST(TreeNode A) {
        return (getValidBST(A, Long.MIN_VALUE, Long.MAX_VALUE) ? 1 : 0);
        ///return isValidBSTInOrder(A,null) ? 1: 0;
        //return (isValid(A, Long.MIN_VALUE, Long.MAX_VALUE) ? 1 : 0);
    }

    public static boolean isValid(TreeNode root, long l, long r) {

        if (root == null) {
            return true;
        }

        if (root.val > l && root.val < r) {
            boolean left = isValid(root.left, l, root.val);
            boolean right = isValid(root.right, root.val, r);
            return (left && right);
        }
        return false;
    }


    public static boolean getValidBST(TreeNode root, long l, long r) {
        if (root == null) return true;


        if (root.val <= l || root.val >= r) return false;

        return getValidBST(root.left, l, root.val) && getValidBST(root.right, root.val, r);
    }

    private static boolean isValidBSTInOrder(TreeNode root, TreeNode prev) {
        if (root == null) {
            return true;
        }

        isValidBSTInOrder(root.left, root);
        if (prev !=null && (root.val > prev.val)) {
            return false;
        }
        isValidBSTInOrder(root.right, root);
        return (prev !=null && root.val > prev.val);
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
