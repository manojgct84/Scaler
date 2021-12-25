package com.balazsholczer.cpop;

import java.util.Comparator;

public class XSorter implements Comparator<Point>{

	@Override
	public int compare(Point point, Point otherPoint) {
		return Double.compare(point.getX(), otherPoint.getX());
	}
}
