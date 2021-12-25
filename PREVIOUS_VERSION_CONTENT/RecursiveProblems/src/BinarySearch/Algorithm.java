package BinarySearch;

public class Algorithm {

	private int[] array;
	
	public Algorithm(int[] array){
		this.array = array;
	}
	
	public int linearSearch(int item){
		
		for(int i=0;i<this.array.length;++i){
			if( item == this.array[i] ){
				return i;
			}
		}
		
		return -1;
	}
	
	public int binarySearch(int item) {
	    return binarySearch(0, this.array.length-1, item);
	}

	private int binarySearch(int startIndex, int endIndex, int item) {
	   
	    if( endIndex < startIndex ) {
			System.out.println("No solution found..");
			return -1; 
		}
	   
		int middleIndex = (startIndex + endIndex) / 2;
	    
		if(endIndex < startIndex) {
	        binarySearch(endIndex, startIndex, item);
	    } 

	    if( item == this.array[middleIndex] ) {
	        return middleIndex;
	    } else if( item < this.array[middleIndex] ) {
	        return binarySearch( startIndex, middleIndex - 1, item );
	    } else {
	        return binarySearch( middleIndex + 1, endIndex, item );
	    }
	}
}
