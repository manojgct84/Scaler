package dc.advance.Trees.BST.class5.homework;

public class MaxSumPathBinaryTree {

    static int ans = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        maxPathSum(root);
        System.out.println(ans);

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.right.right = new TreeNode(5);
        node.right = new TreeNode(3);

        maxPathSum(node);
        System.out.println(ans);
    }

    public static int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        return sumOfAllPath(root);

    }

    private static int sumOfAllPath(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, sumOfAllPath(root.left));
        int right = Math.max(0, sumOfAllPath(root.right));

        ans = Math.max(ans, root.val + Math.max(left ,0) + Math.max(right,0));
        return root.val + Math.max(left, right);
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
