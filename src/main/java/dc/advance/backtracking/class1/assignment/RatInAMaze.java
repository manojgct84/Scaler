package dc.advance.backtracking.class1.assignment;

import java.util.Arrays;

public class RatInAMaze {
	
	public static void main (String[] args) {
		System.out.println(
		Arrays.deepToString(ratInAMaze(new int[][] {{1, 1, 1}, {1, 0, 1}, {0, 0, 1}})));
		System.out.println(
		Arrays.deepToString(ratInAMaze(new int[][] {{1, 0}, {1, 1}})));
	}
	
	public static int[][] ratInAMaze (int[][] A) {
		
		int[][] solution = new int[A.length][A[0].length];
		
		int n = A.length;
		int m = A[0].length;
		bfs(A, solution, 0, 0, n, m);
		return solution;
	}
	
	private static boolean bfs (int[][] mat, int[][] solution, int i, int j, int n, int m) {
		
		if(i == n - 1 && j == m - 1) {
			solution[i][j] = 1;
			return true;
		}
		
		if(i < 0 || i >= n || j < 0 || j >= m) {
			return false;
		}
		
		if(mat[i][j] == 0 || mat[i][j] == 2 || solution[i][j] == 1) {
			return false;
		}
		solution[i][j] = 1;
		mat[i][j] = 2;
		
		if (bfs(mat, solution, i + 1, j, n, m) || bfs(mat, solution, i - 1, j, n, m) ||
		bfs(mat, solution, i, j + 1, n, m) || bfs(mat, solution, i, j - 1, n, m)) {
			return true;
		}
		solution[i][j] = 0;
		return false;
	}
}
