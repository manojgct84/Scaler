package dc.advance.Trees.BST.class6.assignment;

public class LongestConsecutiveOnes
{
    static int length = 0;
    static int res = 0;
    static boolean b = false;
    public static void main (String[] args) {
        
        TreeNode root = new TreeNode (0);
        root.left = new TreeNode (1);
        root.right = new TreeNode (1);
        
        root.left.left = new TreeNode (1);
        root.left.right = new TreeNode (1);
        
        root.right.left = new TreeNode (1);
        root.right.right = new TreeNode (0);
        
        root.left.left.left = new TreeNode (1);
        root.left.left.right = new TreeNode (1);
    
        longestConsecutiveOnes(root, root.data, false);
        System.out.println(res);
        res = 0;
        length = 0;
        longestConsecutiveZeros(root, false);
        System.out.println(res);
        
        res = 0;
        length = 0;
        b = false;
        longestConsecutiveChange (root);
        System.out.println(res);
        
        TreeNode root1 = new TreeNode (0);
        root1.left = new TreeNode (1);
        root1.right = new TreeNode (1);
    
        root1.left.left = new TreeNode (1);
        root1.left.right = new TreeNode (1);
    
        root1.right.left = new TreeNode (1);
        root1.right.left.left = new TreeNode (1);
        root1.right.left.right = new TreeNode (0);
        root1.right.right = new TreeNode (0);
    
        root1.left.left.left = new TreeNode (1);
        root1.left.left.right = new TreeNode (0);
        
        res = 0;
        length = 0;
        b = false;
        longestConsecutiveChange (root1);
        System.out.println(res);
        
        res =0;
        b = false;
        sumOfAllPath(root1);
        System.out.println(res);
    
        res =0;
        b = false;
        sumOfAllPath(root);
        System.out.println(res);
    }

    //Wrong
    private static void longestConsecutiveOnes (TreeNode root, int prev , boolean b)
    {
        if (root == null) {
            return;
        }
        if (root.data == 1 && prev == 1) {
            length++;
        }
        else if ((root.data == 0 && prev == 1) || (root.data == 1 && prev == 0) && !b) {
            length++;
            b = true;
        } else {
            length = 0;
            b = false;
        }
        res = Math.max (res , length);
        longestConsecutiveOnes (root.left, root.data , b);
        longestConsecutiveOnes (root.right, root.data , b);
    }

    //Wrong
    private static boolean longestConsecutiveZeros (TreeNode root, boolean b)
    {
        if (root == null) {
            return true;
        }
        if (root.data == 1) {
            if (longestConsecutiveZeros (root.left , b) && longestConsecutiveZeros (root.right , b)) {
                length++;
            }
            res = Math.max (res , length);
        }
        else if (root.data == 0 && !b) {
            b = true;
            if (longestConsecutiveZeros (root.left , b) && longestConsecutiveZeros (root.right , b)) {
                length++;
            }
             res = Math.max (res , length);
        }
        return true;
    }

    //Wrong
    private static int longestConsecutiveChange (TreeNode root)
    {
        if (root == null) {
            return 0;
        }
       longestConsecutiveChange (root.left);
       longestConsecutiveChange (root.right);
    
        if (root.data == 1) {
             res = Math.max (root.data + res , res);
        } else if (root.data == 0 && !b) {
            res = Math.max (root.data + res , res);
            b = true;
         }
        return res;
    }
    
    //Correct one
    private static int sumOfAllPath(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, sumOfAllPath(root.left));
        int right = Math.max(0, sumOfAllPath(root.right));
        res = Math.max (res , root.data + Math.max (left , 0) + Math.max (right , 0));
        if (root.data == 0 && !b ) {
            b = true;
            return 1 + Math.max (left , right);
        }
        return root.data + Math.max (left , right);
    }
    
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode (int data)
        {
            this.data = data;
        }
    }
}
