package dc.advance.resursion.backtracking2.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumII {
	
	public static void main (String[] args) {
		ArrayList <Integer> A = new ArrayList <>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
		ArrayList <Integer> B = new ArrayList <>(Arrays.asList(2, 1, 3));
		System.out.println(getCombinationSum(A, 8));
		System.out.println(getCombinationSum(B, 3));
		System.out.println(getCombinationSum(new ArrayList <>(Arrays.asList(2, 3, 6, 7)), 7));
	}
	
	public static ArrayList <ArrayList <Integer>> getCombinationSum (ArrayList <Integer> A, int B) {
		Collections.sort(A);
		ArrayList <ArrayList <Integer>> res = new ArrayList <ArrayList <Integer>>();
		findCombinationSumII(res, new ArrayList <Integer>(), 0, A, B);
		return res;
	}
	
	private static void
	findCombinationSumII (
	ArrayList <ArrayList <Integer>> res, ArrayList <Integer> temp, int startIndex,
	ArrayList <Integer> A, int B)
	{

		int cal = checkSumForB(temp);
		if(cal >= B) {
			if(cal == B && !res.contains(temp)) {
				res.add(new ArrayList <>(temp));
			}
			return;
		}

		if(startIndex == A.size()) {
			return;
		}

		for(int i = startIndex; i < A.size(); i++) {
            if(A.get(i) > B) {
                continue;
            }
			temp.add(A.get(i));
			findCombinationSumII(res, temp, i + 1, A, B);
			temp.remove(temp.size() - 1);
		}
	}

	private static int checkSumForB (ArrayList <Integer> temp) {
		int sum = 0;
		for(Integer t : temp) {
			sum += t;
		}
		return sum;
	}
}
