package com.globalsoftwaresupport;

import java.util.Random;

public class QuickSelect {

	private int[] nums;
	
	public QuickSelect(int[] nums) {
		this.nums = nums;
	}
	
	public void sort() {
		for(int i=1;i<nums.length+1;++i) {
			System.out.println(select(i));
		}
	}
	
	public int select(int k) {
		return quickSelect(0, nums.length-1, k-1);
	}
	
	
	// SO PARTITION PHASE
	private int partition(int firstIndex, int lastIndex) {
		
		// index of the random pivot [firstIndex, lastIndex]
		int pivotIndex = new Random().nextInt(lastIndex-firstIndex+1) + firstIndex;
		
		swap(pivotIndex, lastIndex);
		
		for(int i=firstIndex;i<lastIndex;++i) {
			if(nums[i]>nums[lastIndex]) {
				swap(i, firstIndex);
				firstIndex++;
			}	
		}
		
		swap(lastIndex, firstIndex);
		
		// this is the index of the pivot
		return firstIndex;	
	}
	
	private void swap(int pivot, int lastIndex) {
		int temp = nums[pivot];
		nums[pivot] = nums[lastIndex];
		nums[lastIndex] = temp;
	}

	// THIS IS THE SELECTION PHASE
	private int quickSelect(int firstIndex, int lastIndex, int k) {
		
		int pivotIndex = partition(firstIndex, lastIndex);
		
		if(pivotIndex<k) {
			// we can discard the left sub-array so we have to
			// consider the items on the right
			return quickSelect(pivotIndex+1, lastIndex, k);
		} else if(pivotIndex>k) {
			// we can discard the right sub-array so we have to 
			// consider the items on the left
			return quickSelect(firstIndex, pivotIndex-1, k);
		}
		
		return nums[pivotIndex];
	}
}
