package com.balazsholczer.integral;

public class TrapezoidalRule {

	public static void main(String[] args) {
		trapezoidalIntegral(0, 1, 1000);	
	}
	
	public static void trapezoidalIntegral(double a, double b, int N) {

		/**
		 *  h / 2 * [ f(x1) + 2 f(x2) ... + f(xN+1) ] = h * [ f(x1) / 2 + f(x2) ... + f(xN+1) / 2 ]
		 */
		
		double h = (b - a) / N;
		double sum = 0;
		sum += f(a) / 2;

		for (int index = 1; index < N; ++index) {
			sum += f(a + index * h);
		}

		sum += f(b) / 2;
		
		double solution = sum * h;

		System.out.println("Integral solution: " + solution);
	}
	
	public static double f(double x) {
		return x*x;
	}
}
