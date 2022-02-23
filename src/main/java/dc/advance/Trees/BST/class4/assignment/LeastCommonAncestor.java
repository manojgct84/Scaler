package dc.advance.Trees.BST.class4.assignment;

public class LeastCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);

        System.out.println(lca(root, 4, 5));
    }

    public static int lca(TreeNode root, int B, int C) {

        int left = findNodesPresent(root, B);
        int right = findNodesPresent(root, C);
        if (left == -1 || right == -1) {
            return -1;
        }
        return inOrder(root, B, C);
    }

    private static int findNodesPresent(TreeNode root, int val) {

        if (root == null) return -1;

        if (root.val == val) {
            return 1;
        }
        int left = findNodesPresent(root.left, val);
        if (left == 1) {
            return 1;
        }
        return findNodesPresent(root.right, val);
    }

    private static int inOrder(TreeNode root, int B, int C) {

        if (root == null) {
            return -1;
        }

        if (root.val == B || root.val == C) {
            return root.val;
        }

        int left = inOrder(root.left, B, C);
        int right = inOrder(root.right, B, C);

        if (left != -1 && right != -1) {
            return root.val;
        }

        return left != -1 ? left : right;
    }

    //There are 4 way the we will return - parent node having two child which match B & C
    // parent node having one child which match B  and C dont return
    // parent node having one child which match C  and B dont return
    // There is another way both dont match and return null from the child.
    private static TreeNode inOrderClassical(TreeNode root, int B, int C) {

        if (root == null) {
            return null;
        }

        if (root.val == B || root.val == C) {
            return root;
        }

        TreeNode left = inOrderClassical(root.left, B, C);
        TreeNode right = inOrderClassical(root.right, B, C);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
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
