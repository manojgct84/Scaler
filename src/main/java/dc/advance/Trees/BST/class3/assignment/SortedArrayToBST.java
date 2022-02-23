package dc.advance.Trees.BST.class3.assignment;

public class SortedArrayToBST {

    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{1, 2, 3}));
        System.out.println(sortedArrayToBST(new int[]{1, 2, 3, 5, 10}));
        System.out.println(sortedArrayToBST(new int[]{1, 2}));
    }

    public static TreeNode sortedArrayToBST(final int[] A) {

        if (A.length == 0) {
            return null;
        }

        if (A.length == 1) {
            return new TreeNode(A[0]);
        }

        if (A.length == 2) {
            TreeNode node = new TreeNode(A[0]);
            node.right = new TreeNode(A[1]);
            return node;
        }

        return sortedArrayBSTTree(A, 0, A.length - 1);

        /*int len = A.length;

        TreeNode root;

        if (len % 2 != 0) {
            root = new TreeNode(A[(len / 2)]);
        } else {
            root = new TreeNode(A[(len / 2) + 1]);
        }

        TreeNode curr = root;

        int i;
        if (len % 2 != 0) {
            i = (len / 2) - 1;
        } else {
            i = (len / 2);
        }
        while (i >= 0) {
            curr.left = new TreeNode(A[i--]);
            curr = curr.left;
        }

        int j;
        if (len % 2 != 0) {
            j = (len / 2) + 1;
        } else {
            j = (len / 2) + 2;
        }

        curr = root;
        while (j < len) {
            curr.right = new TreeNode(A[j++]);
            curr = curr.right;
        }
        return root;*/
    }

    private static TreeNode sortedArrayBSTTree(int[] A, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + ((e - s) >> 1);
        TreeNode node = new TreeNode(A[mid]);
        node.left = sortedArrayBSTTree(A, s, mid - 1);
        node.right = sortedArrayBSTTree(A, mid + 1, e);
        return node;
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
