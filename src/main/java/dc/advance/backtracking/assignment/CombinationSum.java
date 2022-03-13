package dc.advance.backtracking.assignment;

//Given a set of candidate numbers A and a target number B, find all unique combinations in A where
// the candidate numbers sums to B.
//The same repeated number may be chosen from A unlimited number of times.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {
	
	public static void main (String[] args) {
		//System.out.println(combinationSum(new ArrayList <>(Arrays.asList(2,3)), 2));
		System.out.println(combinationSum(new ArrayList <>(Arrays.asList(2,3,6,7)), 7 ));
	}
	
	
	public static ArrayList <ArrayList <Integer>> combinationSum (ArrayList <Integer> A, int B) {
		
		ArrayList <ArrayList <Integer>> res = new ArrayList <ArrayList <Integer>>();
		Collections.sort(A);
		combinationSumForB(A, B, 0, 0, res, new ArrayList <Integer>());
		return res;
	}
	
	private static void combinationSumForB (
	ArrayList <Integer> a, int b, int sum, int index,
	ArrayList <ArrayList <Integer>> res, ArrayList <Integer> temp)
	{
		
		if(index == a.size()) {
			if(sum == b && !res.contains(temp)) {
				res.add(new ArrayList <>(temp));
			}
			return;
		}
		
		if(sum >= b) {
			if(sum == b && !res.contains(temp)) {
				res.add(new ArrayList <>(temp));
			}
			return;
		}
	 
		for(int i = index; i < a.size(); i++) {
			if(a.get(i) > b) {
				continue;
			}
 			temp.add(a.get(i));
			sum += a.get(i);
			combinationSumForB(a, b, sum, i, res, temp);
			temp.remove(temp.size() - 1);
			sum -=a.get(i);
		}
	}
}
