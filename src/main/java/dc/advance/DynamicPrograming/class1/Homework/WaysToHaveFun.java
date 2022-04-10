package dc.advance.DynamicPrograming.class1.Homework;

public class WaysToHaveFun {
	public static void main (String[] args) {
		System.out.println(waysToHaveFun(2));
		System.out.println(waysToHaveFun(3));
	}
	
	static long[][] dp;
	static int mod = 100000007;
	
	public static int waysToHaveFun (int A) {
		dp = new long[A + 1][3];
		return (int) (waysToHaveFunDp(A, 0) % mod + waysToHaveFunDp(A, 1) % mod  + waysToHaveFunDp(A, 2) % mod ) % mod;
	}
	
	public static long waysToHaveFunDp (int A, int index) {
		if(A == 1) {
			dp[A][0] = 1;
			dp[A][1] = 1;
			dp[A][2] = 1;
			return 1;
		}
		if(A == 2) {
			if(index == 0) {
				dp[A][0] = 3;
			}
			if(index == 1) {
				dp[A][1] = 2;
			}
			if(index == 2) {
				dp[A][2] = 2;
			}
			return dp[A][index];
		}
		if(dp[A][index] != 0) {
			return dp[A][index];
		}
		dp[A][0] = waysToHaveFunDp(A - 1, 0) + waysToHaveFunDp(A - 1, 1) + waysToHaveFunDp(A - 1, 2);
		dp[A][1] = waysToHaveFunDp(A - 1, 0) + waysToHaveFunDp(A - 1, 2);
		dp[A][2] =
		waysToHaveFunDp(A - 1, 0) + waysToHaveFunDp(A - 1, 1) - 2 *  waysToHaveFunDp(A - 2, 2);
		return dp[A][index];
	}
}
