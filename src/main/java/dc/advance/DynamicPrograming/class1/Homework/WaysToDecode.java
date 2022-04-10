package dc.advance.DynamicPrograming.class1.Homework;

import java.util.Arrays;

public class WaysToDecode {
	
	public static void main (String[] args) {
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("8"));
		System.out.println(numDecodings("4126"));
	}
	
	static int[] dp;
	static int mod = 100000007;
	
	public static int numDecodings (String A) {
		if(A.length() == 1) {
			return 1;
		}
		if(A.length() == 2) {
			return 2;
		}
		dp = new int[A.length() + 1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		dp[1] = 1;
		
		char[] c = A.toCharArray();
		System.out.println(waysToDecode(c, c.length));
		return waysToDecodeIterative(c, c.length);
	}
	
	private static int waysToDecode (char[] c, int index) {
		if(index == 1) {
			dp[index] = c[index - 1] - '0' >= 1 && c[index - 1] - '0' <= 9 ? 1 : 0;
			return dp[index] % mod;
		}
		if(index == 2) {
			if(c[index - 2] - '0' == 1) {
				dp[index] = dp[index] % mod + dp[index - 2] % mod;
			}
			else if(c[index - 2] - '0' == 2 && (c[index - 1] - '0' >= 0
			&& c[index - 1] - '0' <= 6)) {
				dp[index] = dp[index] % mod + dp[index - 2] % mod;
			}
			return dp[index];
		}
		
		if(dp[index] != 0) {
			return dp[index];
		}
		dp[index] = waysToDecode(c, index - 1) + (dp[index] % mod + waysToDecode(c, index - 2));
		return dp[index] == -1 ? 0 : Math.abs(dp[index]);
	}
	
	private static int waysToDecodeIterative (char[] c, int index) {
		for(int i = 2; i < index; i++) {
			if(c[i - 1] - '0' >= 1 && c[i - 1] - '0' <= 9) {
				dp[index] = dp[index - 1] % mod;
			}
			else if(c[index - 2] - '0' == 0) {
				dp[index] = 0;
			}
			else if(c[index - 2] - '0' == 1) {
				dp[index] = dp[index] % mod + dp[index - 2] % mod;
			}
			else if(c[index - 2] - '0' == 2 && (c[index - 1] - '0' >= 0
			&& c[index - 1] - '0' <= 6)) {
				dp[index] = dp[index] % mod + dp[index - 2] % mod;
			}
		}
		return dp[index] == -1 ? 0 : dp[index];
	}
}
