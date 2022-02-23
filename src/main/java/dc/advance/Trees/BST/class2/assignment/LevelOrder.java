package dc.advance.Trees.BST.class2.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);

        System.out.println(levelOrder(root).toString());
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(new TreeNode(-1));

        while (!q.isEmpty() && q.size() > 1) {
            TreeNode node = q.poll();
            if (node.val != -1) {
                level.add(node.val);
            }
            if (node.val == -1) {
                res.add(new ArrayList<>(level));
                q.add(new TreeNode(-1));
                level.removeAll(level);
                continue;
            }
            if (q.isEmpty()) {
                break;
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        res.add(new ArrayList<>(level));
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
