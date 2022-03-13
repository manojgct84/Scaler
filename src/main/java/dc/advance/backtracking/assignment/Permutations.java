package dc.advance.backtracking.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
	
	public static void main (String[] args) {
		ArrayList <Integer> permutation = new ArrayList <>(Arrays.asList(1, 2, 3));
		System.out.println(getPermute(permutation));
	}
	
	public static ArrayList <ArrayList <Integer>> getPermute (ArrayList <Integer> A) {
		ArrayList <ArrayList <Integer>> res = new ArrayList <>();
		permute(res, A, 0);
		return res;
		
	}
	
	private static void permute (
	ArrayList <ArrayList <Integer>> res, ArrayList <Integer> a, int index)
	{
		
		if(index == a.size()) {
			res.add(new ArrayList <>(a));
			return;
		}
		
		for(int i = index; i < a.size(); i++) {
			if(i != index && a.get(i).equals(a.get(index))) {
				continue;
			}
			swap(a, i, index);
			permute(res, a, index + 1);
			swap(a, i, index);
		}
	}
	
	private static void swap (ArrayList <Integer> a, int i, int index) {
		int temp = a.get(i);
		a.set(i, a.get(index));
		a.set(index, temp);
	}
}
