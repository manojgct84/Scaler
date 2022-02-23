package dc.advance.Trees.BST.class2.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);

        System.out.println(rightView(root).toString());
    }

    public static ArrayList<Integer> rightView(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        res.add(root.val);
        while (!q.isEmpty() && q.size() > 1) {
            TreeNode node = q.poll();
            if (node == null) {
                if (q.peek() != null) {
                    res.add(q.peek().val);
                }
                q.add(null);
                continue;
            }
            if (node.right != null) {
                q.add(node.right);
            }
            if (node.left != null) {
                q.add(node.left);
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
    }
}
