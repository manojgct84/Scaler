package com.globalsoftwaresupport;

public class BinarySearch {

	public int find(int[] container, int item, int left, int right) {
			
		// this is the search miss when the item is not present in the container
		if(right<left) return -1;
		
		int middleIndex = (left + right) / 2;
		
		// we find the item we are looking for
		if(container[middleIndex] == item) 
			return middleIndex;
		
		// we have to check that the item we are looking for is smaller or
		// greater than the middle_item
		if(container[middleIndex] < item) { 
			// we can discard the left sub-array
			return find(container, item, middleIndex+1, right);
		} else {
			// item is smaller than the middle_item
			// we can discard the right sub-array
			return find(container, item, left, middleIndex-1);
		}	
	}
}
