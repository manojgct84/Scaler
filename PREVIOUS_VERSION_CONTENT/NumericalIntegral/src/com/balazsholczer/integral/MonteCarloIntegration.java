package com.balazsholczer.integral;

import java.util.Random;

public class MonteCarloIntegration {

	public static Random random = new Random();
	public static double R = 1;
	public static double INTERVAL_START = -1;
	public static double INTERVAL_END = 1;
	
	public static void main(String[] args) {
		monteCarlo(10000000);
		// pi = 3.14...
	}
	
	public static void monteCarlo(int numOfIteration){
		
		double insideCounter = 0;
		
		for(int i=0;i<numOfIteration;++i){
			
			double randomX = getRandom();
			double randomY = getRandom();
			
			if( isInside(randomX, randomY) ){
				++insideCounter;
			}
		}
		
		double approximatedArea = ( insideCounter / numOfIteration ) * getMaxArea();
		
		System.out.println("Integrated area is approximately: " + approximatedArea );
	}
	
	public static double getMaxArea(){
		return ( ( INTERVAL_END - INTERVAL_START) * ( INTERVAL_END - INTERVAL_START) ); 
	}
	
	public static double getRandom(){
		return INTERVAL_START + (INTERVAL_END-INTERVAL_START) * random.nextDouble();
	}

	public static boolean isInside(double x, double y){
	
		if( (x*x + y*y) < R*R ){
			return true;
		}
		
		return false;
	}
}
