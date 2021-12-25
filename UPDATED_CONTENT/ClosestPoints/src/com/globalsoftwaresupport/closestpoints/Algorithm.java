package com.globalsoftwaresupport.closestpoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithm {

	private List<Point> points;
	
	public Algorithm(List<Point> points) {
		this.points = points;
	}
	
	public double solveProblem() {
		
		List<Point> sortedXPoints = new ArrayList<>();
		List<Point> sortedYPoints = new ArrayList<>();
		
		for(Point p: this.points) {
			sortedXPoints.add(p);
			sortedYPoints.add(p);
		}
		
		// we have to sort the items (points) based on X and Y
		Collections.sort(sortedXPoints, new XSorter());
		Collections.sort(sortedYPoints, new YSorter());
		
		
		return findClosesPoint(sortedXPoints, sortedYPoints, sortedXPoints.size());
	}

	private double findClosesPoint(List<Point> sortedXPoints, List<Point> sortedYPoints, int numOfPoints) {
		
		if(numOfPoints <= 3)
			return bruteForceSearch(sortedXPoints);
					
		int middleIndex = numOfPoints / 2;
		Point middlePoint = sortedXPoints.get(middleIndex);
		
		// DIVIDE PHASE - we keep dividing the data-set into left and right subarrays
		List<Point> leftSubPointsSortedX = new ArrayList<>();
		List<Point> rightSubPointsSortedX = new ArrayList<>();
		
		// we have to put the points into the valid list
		for(int index=0;index<numOfPoints;++index){
			if(sortedXPoints.get(index).getX() <= middlePoint.getX() ){
				leftSubPointsSortedX.add(sortedXPoints.get(index));
			} else {
				rightSubPointsSortedX.add(sortedXPoints.get(index));
			}
		}
		
		// then we have to find the CPP in the left and right sub-array
		double deltaLeft = findClosesPoint(leftSubPointsSortedX, sortedYPoints, middleIndex);
		double deltaRight = findClosesPoint(rightSubPointsSortedX, sortedYPoints, numOfPoints-middleIndex);
		
		double delta = Math.min(deltaLeft, deltaRight);
		
		List<Point> pointsInStrip = new ArrayList<>();
		
		// linear search for the items that fall within the strip [middleItem.x-delta, middleItem.x + delta]
		for(int index=0;index<numOfPoints;++index){
			if( Math.abs(sortedYPoints.get(index).getX() - middlePoint.getX()) < delta ){
				pointsInStrip.add(sortedYPoints.get(index));
			}
		}
		
		double minDistanceStrip = findMinimumDistanceInStrip(pointsInStrip, delta);
	
		return Math.min(delta, minDistanceStrip);
	}

	private double findMinimumDistanceInStrip(List<Point> points, double delta) {
		
		double minDistance = delta;
		
		// this is a O(N) running time
		for(int i=0;i<points.size();++i){
			// it will have a constant running time (at most 16 iterations)
			for(int j=i+1; j<points.size() && (points.get(j).getY() - points.get(i).getY())<minDistance;++j){
				minDistance = distance(points.get(i), points.get(j));
			}
		}
		
		return minDistance;
	}

	private double bruteForceSearch(List<Point> points) {
		
		// this approach has O(NxN) running time
		// we want to check the distance between the points just once
		// d(a,b) = d(b,a)
		double minDistance = Double.MAX_VALUE;
		
		for(int i=0;i<points.size()-1;++i){
			for(int j=i+1;j<points.size();++j){
				double actualDistance = distance(points.get(i), points.get(j));
				if(actualDistance < minDistance ){
					minDistance = actualDistance;
				}
			}
		}
		
		return minDistance;
	}

	private double distance(Point point1, Point point2) {
		double xDistance = point1.getX() - point2.getX();
		double yDistance = point1.getY() - point2.getY();
		return Math.sqrt(xDistance*xDistance + yDistance*yDistance);
	}
}
