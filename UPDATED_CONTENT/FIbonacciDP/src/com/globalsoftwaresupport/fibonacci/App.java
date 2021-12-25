package com.globalsoftwaresupport.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		
		Map<Integer, Integer> table = new HashMap<>();
		table.put(0, 1);
		table.put(1, 1);
		
		Algorithm algorithm = new Algorithm();
		// it has exponential running time
		System.out.println(algorithm.fibonacciRecursion(20));
		// they have O(N) linear running time
		System.out.println(algorithm.fibonacciMemoization(20, table));
		System.out.println(algorithm.fibonacciTabulation(20, table));
	
	}
}
