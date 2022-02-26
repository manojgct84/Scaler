package dc.advance.Trees.BST.class5.assignment;

import java.util.ArrayList;

public class NodeDistanceCBinaryTree {

    static ArrayList<Integer> res;
    static ArrayList<TreeNode> nodePath;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(nodeDistanceCBinaryTree(root, 3, 3));

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.right.right = new TreeNode(5);
        node.right = new TreeNode(3);
        System.out.println(nodeDistanceCBinaryTree(node, 4, 1));
    }

    public static ArrayList<Integer> nodeDistanceCBinaryTree(TreeNode root, int B, int C) {
        res = new ArrayList<>();
        nodePath = new ArrayList<>();
        getTheNodePath(root, nodePath, B);

        res.addAll(getNodes(nodePath.get(0), C));
        C = C - 1;
        for (int i = 1; i < nodePath.size(); i++) {
            if (C == 0) {
                res.add(nodePath.get(i).val);
            }
            if (nodePath.get(i).left == nodePath.get(i - 1)) {
                res.addAll(getNodes(nodePath.get(i).right, C - 1));
            } else {
                res.addAll(getNodes(nodePath.get(i).left, C - 1));
            }
            C = C - 1;
        }
        return res;
    }

    public static boolean getTheNodePath(TreeNode root, ArrayList<TreeNode> path, int B) {
        if (root == null) {
            return false;
        }

        if (root.val == B) {
            path.add(root);
            return true;
        }

        if (getTheNodePath(root.left, path, B) || getTheNodePath(root.right, path, B)) {
            path.add(root);
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> getNodes(TreeNode A, int C) {
        ArrayList<Integer> nodes = new ArrayList<>();
        if (A == null) {
            return nodes;
        }
        if (C == 0) {
            nodes.add(A.val);
            return nodes;
        }
        ArrayList<Integer> leftNodes = getNodes(A.left, C - 1);
        nodes.addAll(leftNodes);
        ArrayList<Integer> rightNodes = getNodes(A.right, C - 1);
        nodes.addAll(rightNodes);
        return nodes;
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
