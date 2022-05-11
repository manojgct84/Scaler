package dc.advance.DynamicPrograming.class1.Homework;

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
        
        dc.advance.DynamicPrograming.class1.Homework.RobberMaxMoney.TreeNode root = new dc.advance.DynamicPrograming.class1.Homework.RobberMaxMoney.TreeNode (3);
        root.left = new dc.advance.DynamicPrograming.class1.Homework.RobberMaxMoney.TreeNode (2);
        root.right = new dc.advance.DynamicPrograming.class1.Homework.RobberMaxMoney.TreeNode (3);
        root.left.right = new dc.advance.DynamicPrograming.class1.Homework.RobberMaxMoney.TreeNode (3);
        root.right.left = new dc.advance.DynamicPrograming.class1.Homework.RobberMaxMoney.TreeNode (3);
        
        System.out.println (robberMaxMoney(root));
    }
    static java.util.Map <RobberMaxMoney.TreeNode, Integer> dp = new java.util.HashMap <> ();
    public static int robberMaxMoney(dc.advance.DynamicPrograming.class1.Homework.RobberMaxMoney.TreeNode root) {
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
        dc.advance.DynamicPrograming.class1.Homework.RobberMaxMoney.TreeNode left;
        dc.advance.DynamicPrograming.class1.Homework.RobberMaxMoney.TreeNode right;
        
        public TreeNode (int data)
        {
            this.data = data;
        }
    }
}
