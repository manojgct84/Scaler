package dc.advance.DynamicPrograming.class1.Homework;

import java.util.Arrays;

public class MaxSumWithoutAdjacentElements {
	
	public static void main (String[] args) {
		System.out.println(adjacent(new int[][] {{1, 2, 3, 4}, {2, 3, 4, 5}}));
	}
	
	static int[] dp;
	
	public static int adjacent (int[][] A) {
		dp = new int[A[0].length];
		Arrays.fill(dp, Integer.MIN_VALUE);
		int[] arr = new int[A[0].length];
		for(int i = 0; i < A[0].length; i++) {
			arr[i] = Math.max(A[0][i], A[1][i]);
		}
		return maxsum(arr, arr.length - 1);
	}
	
	private static int maxsum (int[] arr, int i) {
		if(i == 0) {
			return Math.max(arr[0], 0);
		}
		if(i == 1) {
			return Math.max(arr[0], Math.max(arr[1], 0));
		}
		if(dp[i] != Integer.MIN_VALUE) {
			return dp[i];
		}
		dp[i] = Math.max(arr[i] + maxsum(arr, i - 2), maxsum(arr, i - 1));
		return dp[i];
	}
}
