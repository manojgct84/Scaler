package dc.advance.DynamicPrograming.class1.Homework;

import java.util.Arrays;

public class DiceThrow {
	
	public static void main (String[] args) {
		System.out.println(diceThrow(4));
		System.out.println(diceThrow(3));
	}
	
	static int[] dp;
	static int mod = 100000007;
	
	public static int diceThrow (int A) {
		dp = new int[A + 1];
		Arrays.fill(dp, -1);
		return diceThrowDp(A, 0);
	}
	
	private static int diceThrowDp (int a, int combination) {
		if(combination == a) {
			return 1;
		}
		if(combination > a) {
			return 0;
		}
		
		if(dp[combination] != -1) {
			return dp[combination];
		}
		int temp = 0;
		int index = 1;
		while(index <= 6) {
			temp = (temp % mod + diceThrowDp(a, combination + index) % mod) % mod;
			index++;
		}
		dp[combination] = temp;
		return dp[combination];
	}
}
