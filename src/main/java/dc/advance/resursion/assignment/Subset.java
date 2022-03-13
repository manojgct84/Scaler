package dc.advance.resursion.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {
	
	public static void main (String[] args) {
		/*        ArrayList<Integer> A = new ArrayList<>();*/
		/*        A.add(1);*/
		/*        A.add(2);*/
		/*        A.add(2);*/
		/*        System.out.println(subsets(A).toString());*/
		System.out.println(subsets(new ArrayList <>(Arrays.asList(1, 2, 2))));
	}
	
	public static ArrayList <ArrayList <Integer>> subsets (ArrayList <Integer> A) {
		Collections.sort(A);
		ArrayList <ArrayList <Integer>> res = new ArrayList <>();
        findAllSubSet(res, new ArrayList <>(), A, 0);
		return res;
		
	}
	
	private static void findUniqueAllSubSet (
	ArrayList <ArrayList <Integer>> res, ArrayList <Integer> val, ArrayList <Integer> a, int index)
	{
		if(!res.contains(val)) {
			res.add(new ArrayList <>(val));
			return;
		}
		for(int i = index; i < a.size(); i++) {
			val.add(a.get(i));
            findUniqueAllSubSet(res, val, a, i + 1);
			val.remove(val.size() - 1);
		}
	}
	
	private static void
	findAllSubSet (
	ArrayList <ArrayList <Integer>> res, ArrayList <Integer> val, ArrayList <Integer> a, int index)
	{
		if(a.size() == index) {
			res.add(new ArrayList <>(val));
			return;
		}
		for(int i = index; i < a.size(); i++) {
			val.add(a.get(i));
			findAllSubSet(res, val, a, i + 1);
			val.remove(val.size() - 1);
		}
	}
	
}
