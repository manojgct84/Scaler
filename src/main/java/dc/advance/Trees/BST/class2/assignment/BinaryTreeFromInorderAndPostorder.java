package dc.advance.Trees.BST.class2.assignment;

public class BinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {

        System.out.println(buildTree(new int[]{2, 1, 3}, new int[]{2, 3, 1}).toString());
        System.out.println(buildTree(new int[]{6, 1, 3, 2}, new int[]{1, 6, 2, 3}).toString());
    }


    public static TreeNode buildTree(int[] in, int[] post) {

        if (post.length == 0 || in.length == 0) {
            return null;
        }

        if (post.length > in.length) {
            return null;
        }

        if (post.length < in.length) {
            return null;
        }

        return mergeInOrderAndPostOrder(post, 0, post.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode mergeInOrderAndPostOrder(int[] post, int postStart, int postEnd, int[] in,
                                                     int inStart, int inEnd) {
        if (postStart > postEnd) {
            return null;
        }

        TreeNode node = new TreeNode(post[postEnd]);

        if (inStart == inEnd) {
            return node;
        }

        int index = searchRootElement(in, post[postEnd]);
        node.right = mergeInOrderAndPostOrder(
                        post, postStart + index, postStart - 1, in, index + 1, inEnd);
        node.left = mergeInOrderAndPostOrder(
                        post, postStart, postStart + index - 1, in, inStart, index - 1);
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
