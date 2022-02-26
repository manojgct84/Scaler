package dc.advance.Trees.BST.class5.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BoundaryTraversalOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);

        System.out.println(anti_clock(root).toString());

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);


        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(anti_clock(node).toString());
    }

    public static ArrayList<Integer> anti_clock(TreeNode root) {
        TreeNode lCurrent = root;
        TreeNode rCurrent = root;
        TreeNode leaf = root;
        ArrayList<Integer> left = leftView(lCurrent);
        ArrayList<Integer> right = rightView(rCurrent);
        ArrayList<Integer> leafNodes = leafNode(leaf, new ArrayList<>());
        //System.out.println("left " + left + " right " + right + " leaf " + leafNodes);

        ArrayList<Integer> res = new ArrayList<>(left);
        merge(leafNodes, res);
        merge((ArrayList<Integer>) reverseList(right), res);
        return res;
    }

    public static <T> List<T> reverseList(ArrayList<T> list) {
        List<T> reverse = new ArrayList<>(list);
        Collections.reverse(reverse);
        return reverse;
    }

    private static void merge(ArrayList<Integer> arr, ArrayList<Integer> res) {
        int i = 0;
        while (i < arr.size()) {
            if (!res.contains(arr.get(i))) {
                res.add(arr.get(i));
            }
            i++;
        }
    }

    private static ArrayList<Integer> leafNode(TreeNode root, ArrayList<Integer> nodes) {

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            nodes.add(root.val);
        }
        leafNode(root.left, nodes);
        leafNode(root.right, nodes);
        return nodes;
    }

    private static ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> right = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty() && q.size() > 1) {
            TreeNode node = q.poll();
            if (node == null) {
                q.add(null);
                continue;
            }
            right.add(node.val);
            if (node.right != null) {
                q.add(node.right);
            } else if (node.left != null) {
                q.add(node.left);
            }
        }
        return right;
    }

    private static ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> left = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty() && q.size() > 1) {
            TreeNode node = q.poll();
            if (node == null) {
                q.add(null);
                continue;
            }
            left.add(node.val);
            if (node.left != null) {
                q.add(node.left);
            } else if (node.right != null) {
                q.add(node.right);
            }
        }
        return left;
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
