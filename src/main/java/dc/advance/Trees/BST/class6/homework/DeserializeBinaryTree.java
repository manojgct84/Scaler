package dc.advance.Trees.BST.class6.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {

    public static void main(String[] args) {
      /*  System.out.println(deserializeBinaryTree(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1))));
        System.out.println(deserializeBinaryTree(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1))));*/
        System.out.println(deserializeBinaryTree(new ArrayList<>(Arrays.asList(1, 2, 4, -1, 3, -1, 5, 7, -1, -1, 6, -1, 8, -1, -1, -1, -1))));
    }

    public static TreeNode deserializeBinaryTree(ArrayList<Integer> arr) {
        TreeNode root = new TreeNode(arr.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < arr.size() - 1) {
            TreeNode curr = q.poll();
            if (curr != null) {
                if (arr.get(i) != -1) {
                    curr.left = new TreeNode(arr.get(i));
                    q.add(curr.left);
                }
                if (arr.get(i + 1) != -1) {
                    curr.right = new TreeNode(arr.get(i + 1));
                    q.add(curr.right);
                }
                i = i + 2;
            } else {
                i++;
            }
        }
        return root;
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
