package dc.advance.backtracking.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {
	
	static Map <Integer, String> map = new HashMap <>();
	
	public static void main (String[] args) {
		System.out.println(Arrays.toString(letterCombinations("23")));
		System.out.println(Arrays.toString(letterCombinations("012")));
	}
	
	private static String[] letterCombinations (String number) {
		map.put(1, "1");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "0");
		
		ArrayList <String> res = new ArrayList <>();
		
		letterPhone(res, "", 0, number, number.length());
		
		return res.toArray(new String[0]);
	}
	
	private static void letterPhone (
	ArrayList <String> res, String temp, int index, String number, int length)
	{
		
		if(index == length) {
			res.add(temp);
			return;
		}
		
		String str = map.get(number.charAt(index) - '0');
		for(int i = 0; i < str.length(); i++) {
			letterPhone(res, temp + str.charAt(i), index + 1, number, length);
		}
	}
}
