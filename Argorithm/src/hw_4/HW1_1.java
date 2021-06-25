package hw_4;

import java.util.Scanner;

public class HW1_1 {

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
		
		int largeSize = Math.max(m, n);
		int smallSize = Math.min(m, n);
		
		int[] dp = new int[smallSize];
		
		if(m==largeSize) {
			for(int i=0; i<largeSize; i++) {
				for(int j=0; j<smallSize; j++) {
					
					if(i==0&&j==0) {
						dp[j] = cell[i][j];
					}
					else if(i==0) {
						dp[j] = cell[i][j] + dp[j-1];
					}
					else if(i!=0 && j==0) {
						dp[j] += cell[i][j];
					}
					else{
						dp[j] = cell[i][j] + Math.min(dp[j], dp[j-1]);
					}
					
				}
			}
		}
		else {
			for(int i=0; i<largeSize; i++) {
				for(int j=0; j<smallSize; j++) {
					
					if(i==0&&j==0) {
						dp[j] = cell[j][i];
					}
					else if(i==0) {
						dp[j] = cell[j][i] + dp[j-1];
					}
					else if(i!=0 && j==0) {
						dp[j] += cell[j][i];
					}
					else{
						dp[j] = cell[j][i] + Math.min(dp[j], dp[j-1]);
					}
					
				}
			}
		}
		System.out.println(dp[smallSize-1]);	
	}

}
