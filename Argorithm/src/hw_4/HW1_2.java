package hw_4;

import java.util.Scanner;

public class HW1_2 {
	
	static int search(int[][] cell) {
		int m = cell.length;
		int n = cell[0].length;
		int min=0;
		
		if(n==1) {
			
			for(int i=0; i<m; i++) {
				min += cell[i][0];
			}
			return min;
		}
		
		else {
			int[] dp = new int[n];
			int temp=0;
			
			for(int i=0; i<n; i++) {
				dp[i] = cell[0][i];
			}
			
			for(int i=1; i<m; i++) {
				for(int j=0; j<n; j++) {
					
					if(j==0) {
						temp = dp[j];
						dp[j] = cell[i][j] + Math.min(dp[j], dp[j+1]);
					}
					else if(j==n-1) {
						dp[j] = cell[i][j] + Math.min(temp, dp[j]);
					}
					else {
						int temp2 = dp[j];
						dp[j] = cell[i][j] + Math.min(Math.min(dp[j], dp[j+1]), temp);
						temp = temp2;
					}
				}
			}
			
			min = dp[0];
			for(int i=1; i<n; i++) {
				if(min>dp[i]) {
					min = dp[i];
				}
			}
			
			return min;
		}
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
		
		System.out.println(search(cell));
		
	}

}
