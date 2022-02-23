package dc.advance.Trees.BST.class2.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);

        ArrayList<Integer> lst = getReverseLevelOrder(root);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = lst.size() - 1; i >= 0; i--) {
            res.add(lst.get(i));
        }
        System.out.println(res.toString());
    }

    private static ArrayList<Integer> getReverseLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> res = new ArrayList<>();

        while (!q.isEmpty() && q.size() > 1) {
            TreeNode node = q.poll();
            if (node != null) {
                res.add(node.val);
            }
            if (node == null) {
                q.add(null);
                continue;
            }

            if (q.isEmpty()) {
                return res;
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
