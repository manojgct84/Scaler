package dc.advance.backtracking.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumII {
	
	public static void main (String[] args) {
		System.out
		.println(getCombinationSum(new ArrayList <>(Arrays.asList(10, 1, 2, 7, 6, 1, 5)), 8));
		System.out.println(getCombinationSum(new ArrayList <>(Arrays.asList(2, 1, 3)), 3));
	}
	
	public static ArrayList <ArrayList <Integer>> getCombinationSum (ArrayList <Integer> A, int B)
	{
		Collections.sort(A);
		ArrayList <ArrayList <Integer>> res = new ArrayList <>();
		combinationSumForB(res, B, new ArrayList <Integer>(), A, 0, 0);
		return res;
	}
	
	private static void combinationSumForB (
	ArrayList <ArrayList <Integer>> res, int b,
	ArrayList <Integer> temp, ArrayList <Integer> input, int index, int sum)
	{
		
		if(input.size() == index) {
			if(sum == b && !res.contains(temp)) {
				res.add(new ArrayList <>(temp));
			}
			return;
		}
		
		if(sum == b && !res.contains(temp)) {
			res.add(new ArrayList <>(temp));
			return;
		}
		
		if(sum > b) {
			return;
		}
		
		for(int i = index; i < input.size(); i++) {
			if(input.get(i) > b) {
				continue;
			}
			temp.add(input.get(i));
			sum += input.get(i);
			combinationSumForB(res, b, temp, input, i + 1, sum);
			temp.remove(temp.size() - 1);
			sum -= input.get(i);
		}
	}
}
