package BinarySearch;

public class App {

	/**
	 * Searching: the aim is to find the index of a given item
	 * 	
	 *   1.) Linear search: in an unsorted array we have to iterate through the
	 *   		whole array sequentially ... checking every item
	 *   				O(N) time complexity
	 *   
	 *   2.) Binary search: we can do better if the array is sorted
	 *   		Finds the position of a target value within a sorted array !!!
	 *   				O(logN) time complexity
	 *   
	 *   The binary search algorithm begins by comparing the target value to 
	 *   	the value of the middle element of the sorted array: 
	 *   			
	 *   			- if this element is greater than the item we are looking for: we
	 *   				continue the search on the left subarray
	 *   			- if the element is less -> we search the right subarray
	 *   
	 *   	Why is it good? We can discard half of the items on every iteration
	 *   		( that's why it will have logarithmic time complexity )
	 * 
	 *	3.) Interpolation search: we can use it if the array is sorted
	 *		  It is like we humans look for a name in a telephone book
	 *				- we make a guess where in the remaining search space the sought item might be
	 *				- in binary search we jump to the middle index ... here this is not the case !!!
	 *					~ we just make a simple linear interpolation
	 *
	 *						O( log log N ) comparisons !!! 
	 *
	 */
	
	
	public static void main(String[] args) {
		
		int[] array = {1,5,6,8,13,22,26,40,50,57,60};
		
		Algorithm algorithm = new Algorithm(array);
		System.out.println(algorithm.binarySearch(5));
		
	}
}
