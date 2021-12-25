package com.globalsoftwaresupport;

public class Fibonacci {

	public int head(int n) {
		
		// we have to define the base cases F(0)=0 and F(1)=1
		if(n==0) return 0;
		if(n==1) return 1;
		
		// first we call the method(s) recursively
		int fib1 = head(n-1);
		int fib2 = head(n-2);
		
		// Java calculates the same values several time
		// this is why DYANMIC PROGRAMMING
		
		// make some operations
		int result = fib1 + fib2;
		return result;		
	}
	
	public int tail(int n, int a, int b) {
				
		 if(n==0) return a;
		 if(n==1) return b;

		 return tail(n-1,b,a+b);
	}
	
	public void iteration(int n) {
		
		int a = 0;
		int b = 1;
		
		while(a<n) {
			System.out.println(a);
			int temp = b;
			b = a + b;
			a = temp;
		}
	}
}

