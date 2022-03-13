package dc.advance.backtracking.homework;

import java.util.HashSet;
import java.util.Set;

public class NumberSquarefulArrays {
	
	public static void main (String[] args) {
		System.out.println(numberSquarefulArrays(new int[] {2, 2, 2}));
		System.out.println(numberSquarefulArrays(new int[] {1, 17, 8}));
		System.out.println(numberSquarefulArrays(new int[] {1, 8, 8}));
		System.out.println(numberSquarefulArrays(new int[] {2850, 286, 155}));
	}
	
	static int perfectSquare = 0;
	
	public static int numberSquarefulArrays (int[] A) {
		perfectSquare = 0;
		findSquare(A, 0);
		return perfectSquare;
	}
	
	private static void findSquare (int[] a, int index) {
		
		if(index == a.length) {
			perfectSquare++;
			return;
		}
		
		Set <Integer> duplicates = new HashSet <>();
		for(int i = index; i < a.length; i++) {
			if(duplicates.contains(a[i])) {
				continue;
			}
			swap(a,i, index);
			if(index == 0 || isSquareRoot(a[index], a[index - 1])) {
				findSquare(a, index + 1);
			}
			swap(a,i, index);
			duplicates.add(a[i]);
		}
	}
	
	private static void swap (int[] a, int i, int index) {
		int  temp = a[i];
		a[i] = a[index];
		a[index] = temp;
	}
	
	private static boolean isSquareRoot (int curr, int prev) {
		int x = (int) Math.sqrt(curr + prev);
		return (x * x) == (curr + prev);
	}
	
}
