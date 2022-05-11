package dc.advance.Trees.BST.class6.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 *          3
 *      /     \
 *   2          3
 *    \           \
 *      3           1
 *
 *
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 *          3     - 0
 *       /     \
 *     4 > 4       5 > 1
 *   /  \           \
 * 1 = true   3 = true          1 - 2
 *
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * */
 
public class RobberMaxMoney
{
    public static void main (String[] args) {
        
        TreeNode root = new TreeNode (3);
        root.left = new TreeNode (2);
        root.right = new TreeNode (3);
        root.left.right = new TreeNode (3);
        root.right.left = new TreeNode (3);
        
        System.out.println (robberMaxMoney(root));
    }
    static Map <TreeNode, Integer> dp = new HashMap <> ();
    public static int robberMaxMoney(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (dp.containsKey (root)) {
            return dp.get (root);
        }
        
        int val = 0;
        if (root.left !=null) { // don't select the root
            val += robberMaxMoney(root.left.left) + robberMaxMoney(root.left.right);
        }
        
        if (root.right !=null) { // don't select the root
            val += robberMaxMoney(root.right.left) + robberMaxMoney(root.right.right);
        }
                                                   // when root  is selected.
        dp.put (root, Math.max(val + root.data , robberMaxMoney(root.left) + robberMaxMoney(root.right)));
        return dp.get (root);
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
