package dc.advance.DynamicPrograming.class6;

public class LongestPalindromicSubsequence
{
    
    public static void main (String[] args)
    {
        System.out.println (longestPalindromicSubsequence ("bebeeed"));
        System.out.println (longestPalindromicSubsequence ("aedsead"));
        
    }
    
    static int[][] dp;
    
    public static int longestPalindromicSubsequence (String A)
    {
        dp = new int[A.length ()][A.length ()];
        for (int i = 0 ; i < A.length () ; i++) {
            java.util.Arrays.fill (dp[i] , -1);
        }
        return longestPalindromicSubsequenceRecursion (0 , A.length () - 1 , A);
    }
    
    private static int longestPalindromicSubsequenceRecursion (int start , int end , String a)
    {
        if (start == end) {
            return 1;
        }
        
        if (start > end) {
            return 0;
        }
        
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        
        if (a.charAt (start) == a.charAt (end)) {
            dp[start][end] = 2 + longestPalindromicSubsequenceRecursion (start + 1 , end - 1 , a);
        }
        else {
            dp[start][end] = Math.max (longestPalindromicSubsequenceRecursion (start + 1 , end , a) ,
                longestPalindromicSubsequenceRecursion (start , end - 1 , a));
        }
        
        return dp[start][end];
    }
}
