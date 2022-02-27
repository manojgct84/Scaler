package dc.advance.Trees.BST.class6.assignment;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointerBinaryTree {

    public static void main(String[] args) {

        TreeLinkNode root = new TreeLinkNode(5);
        root.left = new TreeLinkNode(4);
        root.left.left = new TreeLinkNode(11);
        root.left.left.left = new TreeLinkNode(7);
        root.left.left.right = new TreeLinkNode(2);

        root.right = new TreeLinkNode(8);
        root.right.left = new TreeLinkNode(1);
        root.right.right = new TreeLinkNode(4);
        root.right.right.right = new TreeLinkNode(1);

        connect(root);

        TreeLinkNode node = new TreeLinkNode(5);
        node.left = new TreeLinkNode(4);
        node.left.right = new TreeLinkNode(-11);

        node.right = new TreeLinkNode(8);
        node.right.left = new TreeLinkNode(-13);
        node.right.right = new TreeLinkNode(4);

        connect(node);

    }


    public static void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty() && q.size() > 1) {
            TreeLinkNode node = q.poll();
            if (node == null) {
                q.add(null);
                continue;
            }
            node.next = q.peek();
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left;

        @Override
        public String toString() {
            return "TreeLinkNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }

        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
