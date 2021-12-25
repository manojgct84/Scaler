package com.globalsoftwaresupport.fibonacci;

public class Algorithm {

	private int rodLength;
	private int[][] dpTable;
	private int[] prices;
	
	public Algorithm(int rodLength, int[] prices) {
		this.rodLength = rodLength;
		this.prices = prices;
		this.dpTable = new int[prices.length+1][rodLength+1];
	}
	
	public void solve() {		
		for(int i=1;i<prices.length;i++) {
			for(int j=1;j<rodLength+1;j++) {
				if( i <= j ) {
					dpTable[i][j] = Math.max(dpTable[i-1][j], prices[i] + dpTable[i][j-i]);
				} else {
					dpTable[i][j] = dpTable[i-1][j];
				}
			}
		}
	}
	
	public void show() {
		
		System.out.println("Optimal profit: $" + dpTable[prices.length-1][rodLength]);
		
		for(int rowIndex=prices.length-1, colIndex=rodLength;rowIndex>0;) {
			if( dpTable[rowIndex][colIndex] != 0 && dpTable[rowIndex][colIndex] != dpTable[rowIndex-1][colIndex]) {
				System.out.println("We use piece: "+rowIndex+"m");
				colIndex = colIndex - rowIndex;
			} else {
				rowIndex--;
			}
		}
	}
}
