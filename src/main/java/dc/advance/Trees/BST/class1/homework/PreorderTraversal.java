package dc.advance.Trees.BST.class1.homework;

import java.util.ArrayList;

public class PreorderTraversal {

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

            System.out.println(preorderTraversal(root).toString());

        }

        public static ArrayList<Integer> preorderTraversal(TreeNode root) {

            ArrayList<Integer> lst = new ArrayList<>();
            preorderTraversalRecursion(root, lst);
            return lst;
        }

        private static void preorderTraversalRecursion(TreeNode root, ArrayList<Integer> lst) {
            if (root == null) {
                return;
            }
            lst.add(root.val);
            preorderTraversalRecursion(root.left, lst);
            preorderTraversalRecursion(root.right, lst);
        }
    }
}
