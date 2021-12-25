package com.globalsoftwaresupport;

public class Factorial {

	public int head(int n) {
		
		// the factorial of 1 is 1 (1!=1)
		if(n==1) return 1;
		
		// first we call the method recursively
		// n! = n*(n-1)!
		int res1 = head(n-1);
		
		// we do some operations
		int result = n*res1;	
		return result;	
	}
	
	public int tail(int n, int accumulator) {
		
		if(n==1) return accumulator;
		
		return tail(n-1, n*accumulator);
	}
}

