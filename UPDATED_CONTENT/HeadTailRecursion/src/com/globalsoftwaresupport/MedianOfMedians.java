package com.globalsoftwaresupport;

import java.util.Arrays;
import java.util.Random;

public class MedianOfMedians {

	private int[] nums;
	
	public MedianOfMedians(int[] nums) {
		this.nums = nums;
	}
	
	public int select(int k) {
		return quickSelect(0, nums.length-1, k-1);
	}
	
	private int getMedian(int nums[], int n) {
		
		// for(int in : nums)
			//System.out.print(in);
		
        Arrays.sort(nums);
        return nums[n/2];
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
	
	private void pickCleverPivot(int left, int right){
		
		    int n = right-left;
		
		    int numofMedians = (int) Math.ceil(n/5);
		
		    int[] medians = new int[numofMedians];
		
		    int[] groups = new int[5];
		
		     
		
		    for(int i = 0; i < numofMedians; i++) {
		
		        if (i != numofMedians - 1){
		
		            for (int j = 0; j < 5; j++){
		
		                groups[j] = nums[(i*5)+j];
		                System.out.println(groups[j]);
		
		            }
		
		            medians[i] = getMedian(groups, 5);
		
		        } else {
		
		            int numOfRemainders = n % 5;
		
		            int[] remainder = new int[numOfRemainders];
		
		           for (int j = 0; j < numOfRemainders; j++){
		
		                remainder[j] = nums[(i*5)+j];
		                System.out.println(remainder[j]);
		
		            }
		
		            medians[i] = getMedian(groups, 5);
		
		        }
		
		    }
		
		    //for(int in : groups)
		    	//System.out.println(in);
		
		}


	// THIS IS THE SELECTION PHASE
	private int quickSelect(int firstIndex, int lastIndex, int k) {
		
		pickCleverPivot(firstIndex, lastIndex);

		
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
