package dc.advance.DynamicPrograming.class3;

import java.util.Arrays;

public class RegularExpressionMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a*"));
        System.out.println(isMatch("acz", "a?a"));
        System.out.println(isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "*b"));
        System.out.println(isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a**************************************************************************************"));
    }

    static int[][] isMatch;
    public static int isMatch(final String A, final String B) {
        isMatch = new int[A.length() + 1][B.length() + 1];
        for (int[] match : isMatch) {
            Arrays.fill(match, 0);
        }
         regularExpressionMatch(A, B, A.length(), B.length());
         System.out.println(isMatch[A.length()][B.length()]);
        return regularExpressionMatchIterative(A, B, A.length(), B.length());
    }

    private static int regularExpressionMatch(String a, String b, int n, int m) {
        if (n == 0 && m == 0) {
            return 0;
        } else if (n == 0) {
            if (b.charAt(m - 1) == '*') {
                return 1;
            }
        } else if (m == 0) {
            return 0;
        } else if (a.charAt(n - 1) == b.charAt(m - 1) || b.charAt(m - 1) == '?') {
            isMatch[n][m] = 1 + regularExpressionMatch(a, b, n - 1, m - 1);
        } else if (b.charAt(m - 1) == '*') {
            if (regularExpressionMatch(a, b, n, m - 1) == 1 ||
                regularExpressionMatch(a, b, n - 1, m) == 1) {
                isMatch[n][m] = 1;
            }
        }
        return isMatch[n][m];
    }

    private static int regularExpressionMatchIterative(String a, String b, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], 0);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= b.length(); i++) {
            if (b.charAt(i - 1) == '*') {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) || b.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (b.charAt(j - 1) == '*') {
                    if (dp[i - 1][j] == 1 || dp[i][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return dp[n][m];
    }
}