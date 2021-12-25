package com.globalsoftwaresupport.closestpoints;

import java.util.Comparator;

public class YSorter implements Comparator<Point> {

	// but we have to define the logic behind sorting: tell Java how to compare
	// the items in the underlying data structure
	
	@Override
	public int compare(Point o1, Point o2) {
		return Double.compare(o1.getY(), o2.getY());
	}
}
