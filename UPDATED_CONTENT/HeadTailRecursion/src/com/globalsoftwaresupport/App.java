package com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		
		MedianOfMedians quickSelect = new MedianOfMedians(nums);
		quickSelect.select(1);
	
	}
}
