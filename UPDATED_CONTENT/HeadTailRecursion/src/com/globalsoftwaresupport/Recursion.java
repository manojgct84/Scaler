package com.globalsoftwaresupport;

public class Recursion {

	public void head(int n) {
		
		System.out.println("Calling the function with n="+n);
		
		if(n==0) return;
		
		// we call the method recursively 
		head(n-1);
		
		// we do some operations
		// operation = Systeml.out.println()
		System.out.println("The value n="+n);
	}
	
	public void tail(int n) {
		
		System.out.println("Calling the function with n="+n);
		
		if(n==0) return;
		
		// do some operations
		System.out.println("The value is n=" + n);
		
		// we call the method recursively
		tail(n-1);
	}
}
