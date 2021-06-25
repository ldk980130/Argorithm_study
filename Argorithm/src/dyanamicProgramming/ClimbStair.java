package dyanamicProgramming;

import java.util.Scanner;

public class ClimbStair {//연속된 수만큼 계단 오르기
	
	static int climbStair(int n, int k) {
		
		int[] stair = new int[n+1];
		stair[0] = 1;
		
		for(int i=1; i<=k; i++) {
			for(int j=1; j<=i; j++) {
				stair[i] += stair[i-j];
			}
		}
		for(int i=k+1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				stair[i] += stair[i-j];
			}
		}
		
		return stair[n];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(climbStair(n,k));
	}

}
