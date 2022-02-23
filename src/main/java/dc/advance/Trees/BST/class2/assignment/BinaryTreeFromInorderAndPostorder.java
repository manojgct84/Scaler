package dc.advance.Trees.BST.class2.assignment;

public class BinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {

        System.out.println(buildTree(new int[]{2, 1, 3}, new int[]{2, 3, 1}).toString());
        System.out.println(buildTree(new int[]{6, 1, 3, 2}, new int[]{1, 6, 2, 3}).toString());
    }


    public static TreeNode buildTree(int[] in, int[] pre) {

        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        if (pre.length > in.length) {
            return null;
        }

        if (pre.length < in.length) {
            return null;
        }

        return mergeInOrderAndPostOrder(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode mergeInOrderAndPostOrder(int[] pre, int preStart, int preEnd, int[] in,
                                                     int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode node = new TreeNode(pre[preEnd]);

        if (inStart == inEnd) {
            return node;
        }

        int index = searchRootElement(in, pre[preEnd]);
        node.right = mergeInOrderAndPostOrder(
                pre, preStart + index, preEnd - 1, in, index + 1, inEnd);
        node.left = mergeInOrderAndPostOrder(
                pre, preStart, preStart + index - 1, in, inStart, index - 1);
        return node;
    }

    private static int searchRootElement(int[] in, int value) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == value) {
                return i;
            }
        }
        return -1;
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
