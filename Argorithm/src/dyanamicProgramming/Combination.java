package dyanamicProgramming;

import java.util.Scanner;

public class Combination {

	static int combination(int n, int k) {
		
		if(k==0 || n==k) {
			return 1;
		}
		else {
			return combination(n-1, k) + combination(n-1, k-1);
		}	
	}
	
	static int combinationDynamic(int n, int k) {
		
		int[][] table = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=Math.min(i, k); j++) { // k대신 i도 가능
				
				if(j==0 || i==j) {
					table[i][j] = 1;
				}
				else {
					table[i][j] = table[i-1][j] + table[i-1][j-1];
				}
				
			}
		}
		return table[n][k];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(combinationDynamic(n, k));
	}

}
