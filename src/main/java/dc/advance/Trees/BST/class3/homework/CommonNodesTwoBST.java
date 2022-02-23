package dc.advance.Trees.BST.class3.homework;

import java.util.HashSet;
import java.util.Set;

public class CommonNodesTwoBST {

    static int total = 0;
    static int mod = 1000000007;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(9);


        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.right = new TreeNode(10);
        node.right.right = new TreeNode(15);
        node.right.left = new TreeNode(11);

        System.out.println(commonNodesTwoBST(root, node));

    }

    public static int commonNodesTwoBST(TreeNode A, TreeNode B) {

        Set<Integer> set = new HashSet<>();
        storeInSet(A, set);
        total = 0;
        return findCommon(B, set);
    }

    private static int findCommon(TreeNode b, Set<Integer> set) {
        if (b == null) {
            return 0;
        }
        if (set.contains(b.val)) {
            total = (total % mod + b.val % mod) % mod;
        }
        findCommon(b.left, set);
        findCommon(b.right, set);
        return total % mod;
    }

    private static void storeInSet(TreeNode a, Set<Integer> set) {
        if (a == null) {
            return;
        }
        storeInSet(a.left, set);
        set.add(a.val);
        storeInSet(a.right, set);
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
