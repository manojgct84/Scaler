package com.balazsholczer.fibonacci;

public class App {

	public static void main(String[] args) {

		FibonacciAlgorithm fibonacciAlgorithm = new FibonacciAlgorithm();
		System.out.println(fibonacciAlgorithm.fibonacciMemoize(3));

	}
}
