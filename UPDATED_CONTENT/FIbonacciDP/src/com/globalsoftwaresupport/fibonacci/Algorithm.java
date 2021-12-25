package com.globalsoftwaresupport.fibonacci;

import java.util.Map;

public class Algorithm {

	public int fibonacciRecursion(int n) {
		
		if(n==0)
			return 1;
		
		if(n==1)
			return 1;
		
		return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
	}
	
	// top-down approach MEMOIZATION
	public int fibonacciMemoization(int n, Map<Integer, Integer> table) {
		
		if(!table.containsKey(n))
			table.put(n, fibonacciMemoization(n-1, table)+fibonacciMemoization(n-2, table));
		
		// O(1) constant running time
		return table.get(n);
	}
	
	// bottom-up approach TABULATION
	public int fibonacciTabulation(int n, Map<Integer, Integer> table) {
			
		// this has O(N) linear running time complexity
		for(int i=2;i<=n;i++)
			table.put(i, table.get(i-1)+table.get(i-2));
		
		return table.get(n);
	}
}
