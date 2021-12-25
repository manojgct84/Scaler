package com.balazsholczer.integral;

public class NewtonRaphsonMethod {

	public static final double error = 0.001;

	public static void main(String[] args) {
		newtonMethod();
	}

	public static void newtonMethod() {

		double x = 5;

		while ( Math.abs(f(x)) > error ) {
			x = x - (f(x) / df(x));
		}

		System.out.println("Approximated root: " + x);
	}

	public static double f(double x) {
		return x * x - 10;
	}

	public static double df(double x) {
		return 2 * x;
	}
}
