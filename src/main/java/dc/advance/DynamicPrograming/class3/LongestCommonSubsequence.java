package dc.advance.DynamicPrograming.class3;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abbcdgf",
                "bbadcgf"));
        System.out.println(longestCommonSubsequence("aaaaaa",
                "ababab"));
    }

    static int[][] dp;
    static int[][] lcs;

    public static int longestCommonSubsequence(String A, String B) {
        dp = new int[A.length() + 1][B.length() + 1];
        lcs = new int[A.length() + 1][B.length() + 1];
        longestCommonSubsequenceRecursion(A, B, A.length(), B.length());
        System.out.println(dp[0][0]);
        return longestCommonSubsequenceIterative(A, B);
    }

    private static int longestCommonSubsequenceRecursion(String a, String b, int s1, int s2) {
        if (s1 == 0 || s2 == 0) {
            return 0;
        } else if (a.charAt(s1 - 1) == b.charAt(s2 - 1)) {
            dp[s1][s2] = 1 + longestCommonSubsequenceRecursion(a, b, s1 - 1, s2 - 1);
        } else {
            dp[s1][s2] = Math.max(longestCommonSubsequenceRecursion(a, b, s1 - 1, s2),
                    longestCommonSubsequenceRecursion(a, b, s1, s2 - 1));
        }
        return dp[s1][s2];
    }

    private static int longestCommonSubsequenceIterative(String a, String b) {
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                    continue;
                }
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[a.length()][b.length()];
    }
}
