package dc.advance.DynamicPrograming.class1;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumber {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(fibonacciNumber(in.nextInt()));
	}
	
	static int[] dp;
	public static int fibonacciNumber (int n) {
		dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		Arrays.fill(dp, 2, n + 1, -1);
		return getFibonacciNumber(n);
	}
	
	public static int getFibonacciNumber (int n) {
		if(n == 0) {
			return dp[0];
		}
		
		if(n == 1) {
			return dp[1];
		}
		
		if(dp[n] != -1) {
			return dp[n];
		}
		
		dp[n] = getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
		
		return dp[n];
	}
}
