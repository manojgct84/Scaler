package dc.advance.Trees.BST.class2.homework;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);

        System.out.println(zigzagLevelOrder(root).toString());

        TreeNode node = new TreeNode(26);
        node.left = new TreeNode(10);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(3);

        System.out.println(zigzagLevelOrder(node).toString());
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        boolean toggle = true;
        while (!s.isEmpty()) {
            Stack<TreeNode> tempStack = new Stack<>();
            while (!s.isEmpty()) {
                TreeNode node = s.pop();
                if (node != null) {
                    level.add(node.val);
                }
                if (!toggle) {
                    if (node.right != null) {
                        tempStack.add(node.right);
                    }
                    if (node.left != null) {
                        tempStack.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        tempStack.add(node.left);
                    }
                    if (node.right != null) {
                        tempStack.add(node.right);
                    }
                }
            }
            toggle =!toggle;
            s  = tempStack;
            res.add(new ArrayList<>(level));
            level.removeAll(level);
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
