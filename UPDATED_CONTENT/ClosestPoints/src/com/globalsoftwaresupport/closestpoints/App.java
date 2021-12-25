package com.globalsoftwaresupport.closestpoints;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Point> points = Arrays.asList(
				new Point(2.5, 3), 
				new Point(3, 3),
				new Point(1, 1),
				new Point(1, 2),
				new Point(2, 1),
				new Point(2, 2));
		
		Algorithm a = new Algorithm(points);
		System.out.println(a.solveProblem());
		
	}
}
