package EuclideanAlgorithm;

public class App {

	/**
	 *  It is an efficient method for computing the greatest common divisor (GCD)
	 *  	of two numbers, the largest number that divides both of them
	 *  		 without leaving a remainder
	 * 
	 */
	
	public static void main(String[] args) {
		
		Algorithm algorithm = new Algorithm();
		System.out.println( algorithm.gcdRecursive(30,100) );
		
	}
}
