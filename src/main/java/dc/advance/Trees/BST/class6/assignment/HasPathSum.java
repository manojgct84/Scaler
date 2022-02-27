package dc.advance.Trees.BST.class6.assignment;

public class HasPathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.right = new TreeNode(-11);

        node.right = new TreeNode(8);
        node.right.left = new TreeNode(-13);
        node.right.right = new TreeNode(4);

        System.out.println(hasPathSum(node, -1));


        TreeNode node1 = new TreeNode(1000);
        node1.left = new TreeNode(200);

        System.out.println(hasPathSum(node1, 1000));
    }

    public static int hasPathSum(TreeNode root, int B) {

        return sumThePath(root, 0, B);
    }

    private static int sumThePath(TreeNode root, int sum, int b) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (sum + root.val == b) {
                return 1;
            }
        }

        int l = sumThePath(root.left, sum + root.val, b);
        int r = sumThePath(root.right, sum + root.val, b);
        if (l == 1 || r == 1) {
            return 1;
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
