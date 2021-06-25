package dyanamicProgramming;

import java.util.Scanner;

public class LCS {
	
	static int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int[][] dp = new int[m+1][n+1];
		s1 = " "+s1;
		s2 = " "+s2;
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n;j++) {
				
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		System.out.println(lcs(s1, s2));
	}

}
