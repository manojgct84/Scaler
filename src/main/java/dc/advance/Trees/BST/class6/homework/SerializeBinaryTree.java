package dc.advance.Trees.BST.class6.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(serializeBinaryTree(root));

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right = new TreeNode(3);

        System.out.println(serializeBinaryTree(node));
    }

    public static ArrayList<Integer> serializeBinaryTree(TreeNode root) {

        return levelOrder(root);

    }

    private static ArrayList<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty() && q.size() > 1) {
            TreeNode node = q.poll();
            if (node == null) {
                q.add(null);
                continue;
            }
            if (node.val == -1) {
                res.add(node.val);
                continue;
            }
            res.add(node.val);
            //System.out.print(node.val);
            if (node.left != null) {
                q.add(node.left);
            } else if (node != null && node.left == null) {
                q.add(new TreeNode(-1));
            }

            if (node.right != null) {
                q.add(node.right);
            } else if (node != null && node.right == null) {
                q.add(new TreeNode(-1));
            }
        }
        return res;
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
