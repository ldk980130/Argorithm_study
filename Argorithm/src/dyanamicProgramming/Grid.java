package dyanamicProgramming;

import java.util.Scanner;

public class Grid {
	
	static int grid(int[][] cell) {
		
		int m = cell.length;
		int n = cell[0].length;
		
		int[][] dp = new int[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				
				if(i==0) {
					dp[i][j] = cell[i][j];
				}
				else if(j==0) {
					dp[i][j] = cell[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
				}
				else if(j==n-1) {
					dp[i][j] = cell[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
				}
				else {
					dp[i][j] = cell[i][j] + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]);
				}
			}
		}
		
		int min = dp[m-1][0];
		for(int i=1; i<n; i++) {
			
			if(min>dp[m-1][i]) {
				min = dp[m-1][i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] cell = new int[m][n];
		for(int i=m-1; i>=0; i--) {
			for(int j=0; j<n; j++) {
				cell[i][j]=sc.nextInt();
			}
		}
		
		System.out.println(grid(cell));
	}

}
