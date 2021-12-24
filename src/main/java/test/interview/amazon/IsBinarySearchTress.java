package test.interview.amazon;

import java.util.Stack;

public class IsBinarySearchTress {

    public static void main(String[] args) {
        // Initialize binary tree
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(5);
        root.left.right = new Node(11);

        if (isBST(root)) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

    /**
     * 15
     * 10    20
     * 5  11
     */
    static boolean isBST(Node root) {

        if (root == null) {
            return true;
        }

        if (root.value < root.left.value || root.value > root.right.value) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root); //15
        Node prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                if (root.left != null) {
                    stack.push(root.left);
                }
                root = root.left;
            }
            // System.out.println(stack.toString());
            //[10 ,15]
            root = stack.isEmpty() ? null : stack.pop(); //15
            System.out.println("After pop " + stack.toString());
            if (prev != null && root != null && !(prev.value < root.value)) {
                return false;
            }
            prev = root;  //15
            if (root != null) {
                root = root.right;
                if (root != null)
                    System.out.println(root.toString());
            }
        }
        return true;
    }
}


class Node {
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [" +
                "value=" + value +
                ']';
    }

    int value;
    Node left = null;
    Node right = null;

}
