package dc.advance.backtracking.assignment;

//Given a set of distinct integers A, return all possible subsets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 */
public class Subset {
	
	public static void main (String[] args) {
		System.out.println(findUniqueSubsetsDiff(new ArrayList <>(Arrays.asList(1, 2, 3))));
		System.out.println(findUniqueSubsetsDiff(new ArrayList <>(Arrays.asList(12, 13))));
		System.out.println(findUniqueSubsetsDiff(new ArrayList <>(Arrays.asList(1, 5, 2, 1))));
		System.out.println("************************");
		System.out.println(findUniqueSubsets(new ArrayList <>(Arrays.asList(1, 2, 3))));
		System.out.println(findUniqueSubsets(new ArrayList <>(Arrays.asList(12, 13))));
		System.out.println(findUniqueSubsets(new ArrayList <>(Arrays.asList(1, 5, 2, 1))));
	}
	
	public static ArrayList <ArrayList <Integer>> findUniqueSubsets (ArrayList <Integer> A) {
		ArrayList <ArrayList <Integer>> res = new ArrayList <>();
		Collections.sort(A);
		generateAllSubSets(res, 0, new ArrayList <Integer>(), A);
		return res;
	}
	
	private static void generateAllSubSets (
	ArrayList <ArrayList <Integer>> res, int index,
	ArrayList <Integer> temp, ArrayList <Integer> a)
	{
		if(!res.contains(temp)) {
			res.add(new ArrayList <>(temp));
		}
		
		for(int i = index; i < a.size(); i++) {
			if(temp.contains(a.get(i))) {
				continue;
			}
			temp.add(a.get(i));
			generateAllSubSets(res, index + 1, temp, a);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static ArrayList <ArrayList <Integer>> findUniqueSubsetsDiff (ArrayList <Integer> A) {
		ArrayList <ArrayList <Integer>> res = new ArrayList <>();
		Collections.sort(A);
		res.add(new ArrayList <>());
		allSubSets(res, 0, new ArrayList <Integer>(), A);
		return res;
	}
	
	private static void allSubSets (
	ArrayList <ArrayList <Integer>> res, int index,
	ArrayList <Integer> temp, ArrayList <Integer> a)
	{
		if(index == a.size()) {
			return;
		}
		
		temp.add(a.get(index));
		res.add(new ArrayList <>(temp));
		allSubSets(res, index + 1, temp, a); // do
		temp.remove(temp.size() - 1); // undo
		allSubSets(res, index + 1, temp, a); // backtract
	}
	
}
