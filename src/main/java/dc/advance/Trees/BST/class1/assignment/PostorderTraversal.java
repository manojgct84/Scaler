package dc.advance.Trees.BST.class1.assignment;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(9);
            root.right = new TreeNode(15);
            root.left.left = new TreeNode(8);
            root.left.right = new TreeNode(5);
            root.left.left.left = new TreeNode(4);
            root.right.left = new TreeNode(14);
            root.right.right = new TreeNode(17);

            System.out.println(postorderTraversal(root).toString());
            postorderTraversalIterative(root);
        }

        private static void postorderTraversalIterative(TreeNode root) {
            Stack<TreeNode> stk = new Stack<>();
            while (true) {
                while (root != null) {
                    stk.push(root);
                    stk.push(root);
                    root = root.left;
                }

                if (stk.isEmpty()) {
                    return;
                }

                root = stk.pop();
                if (!stk.isEmpty() && root == stk.peek()) {
                    root = root.right;
                } else {
                    System.out.print(root.val);
                    System.out.print(" ");
                    root = null;
                }
            }
        }

        public static ArrayList<Integer> postorderTraversal(TreeNode A) {
            ArrayList<Integer> res = new ArrayList<>();
            postorder(A, res);
            return res;
        }

        private static void postorder(TreeNode root, ArrayList<Integer> res) {
            if (root == null) {
                return;
            }
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }
}
