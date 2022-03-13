package dc.advance.backtracking.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class SIXLETS {
	
	public static void main (String[] args) {
		System.out.println(getSIXLETS(new ArrayList <>(Arrays.asList(5, 17, 1000, 11)), 4));
		System.out.println("res " + res);
		System.out.println(getSIXLETS(new ArrayList <>(Arrays.asList(1, 2, 8)), 2));
		System.out.println("res " + res);
	}
	
	static int res;
	public static int getSIXLETS (ArrayList <Integer> A, int B) {
		res = 0;
		nonEmptySubsequencesDiff(A, B, 0, 1000, 0 , new ArrayList<>());
		return nonEmptySubsequences(A, B, 0, 1000, 0, new ArrayList<>());
		
	}
	
	private static int nonEmptySubsequences (
	ArrayList <Integer> a, int size, int index, int total,
	int sum, ArrayList <Integer> temp)
	{
		
		if(index == a.size()) {
			if(sum <= total && size == temp.size()) {
				return 1;
			}
			return 0;
		}
		
		if(sum == total && size == temp.size()) {
			return 1;
		}
		
		if(sum > total) {
			return 0;
			
		}
		sum += a.get(index);
		temp.add(a.get(index));
		//don't change the size here
		int x = nonEmptySubsequences(a, size, index + 1, total, sum, temp); // do
		sum -= a.get(index);
		temp.remove(temp.size() - 1); // undo backtrack
		//don't change the size here
		int y = nonEmptySubsequences(a, size, index + 1, total, sum, temp);
		return x + y;
		
	}
	
	private static void nonEmptySubsequencesDiff (
	ArrayList <Integer> a, int size, int index, int total,
	int sum,  ArrayList <Integer> temp)
	{
		
		if(index == a.size()) {
			if(sum <= total && size == 0) {
				res++;
			}
			return;
		}
		
		if(sum == total && size == 0) {
			res++;
			return;
		}
		
		if(sum > total) {
			return;
			
		}
		sum += a.get(index);
		//change the size to reach zero
		nonEmptySubsequencesDiff(a,  size - 1, index + 1, total, sum, temp);
		sum -= a.get(index);	//undo
		nonEmptySubsequencesDiff(a, size, index + 1, total, sum, temp); // backtrack
	}
}
