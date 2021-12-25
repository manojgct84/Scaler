package com.globalsoftwaresupport.fibonacci;

public class App {

	public static void main(String[] args) {
		
		int n = 5;
		int[] prices = {0, 2, 5, 7, 3, 20};
		
		
		Algorithm a = new Algorithm(n, prices);
		a.solve();
		a.show();
	
	}
}
