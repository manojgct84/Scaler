package com.balazsholczer.integral;

public class SimpsonIntegral {

	/**
	 *  integral ~ h / 3 [ f(x0) + 4f(x1) + 2 f(x2) + 4f(x3) + 2f(x4) + ... + 4f(xN-1) + f(xN) ]
	 * 
	 * 	=  h * [ 1/3 f(x0) + 4/3 f(x1) + 2/3 f(x2) ..... 1/3 f(xN) ]
	 */
	
	public static void main(String[] args) {

		simpsonIntegral(0, 1, 10000);

	}

	public static void simpsonIntegral(double a, double b, int N) {

		double h = (b - a) / N;

		// 1/3 terms
		double sum = 1.0 / 3.0 * (f(a) + f(b));

		// 4/3 terms
		for (int i = 1; i < N; i += 2) {
			sum += 4.0 / 3.0 * f(a + h * i);
		}

		// 2/3 terms
		for (int i = 2; i < N; i += 2) {
			sum += 2.0 / 3.0 * f(a + h * i);
		}

		double solution = sum * h;

		System.out.println("Integral is: " + solution);
	}

	public static double f(double x) {
		return Math.pow(x, x);
	}
}
