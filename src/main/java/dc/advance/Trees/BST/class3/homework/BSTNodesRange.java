package dc.advance.Trees.BST.class3.homework;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BSTNodesRange {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(14);
        root.left.left.left = new TreeNode(8);

        root.right = new TreeNode(20);
        root.right.right = new TreeNode(27);
        root.right.left = new TreeNode(16);


        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(21);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);

        System.out.println(getSolve(root,12,20));
        System.out.println(getSolve(node,2,20));

    }
    private static void storeInSet(TreeNode a, Set<Integer> set) {
        if (a == null) {
            return;
        }
        storeInSet(a.left, set);
        set.add(a.val);
        storeInSet(a.right, set);
    }

    public static int getSolve(TreeNode A, int B, int C) {
        Set<Integer> set = new TreeSet<>();
        storeInSet(A, set);
        Iterator<Integer> itr = set.iterator();
        int count = 0;
        while (itr.hasNext()) {
            int b = itr.next();
            if (b >= B && b <= C) {
                count++;
            }
        }
        return count;
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
