package com.globalsoftwaresupport;

public class LinearSearch {

	public int find(int[] container, int item) {
		
		// this is why the running time is O(N)
		for(int index=0;index<container.length;++index) {
			// this is when we find the given item
			if(container[index] == item)
				return index;
		}
		
		// this is the search miss when the item is not found
		return -1;
	}
	
	public int recursiveFind(int[] container, int item, int index) {
		
		// search miss
		if(index >= container.length) return -1;
		
		// base case when we find the item
		if(container[index] == item) return index;
		
		return recursiveFind(container, item, index+1);
	}
}
