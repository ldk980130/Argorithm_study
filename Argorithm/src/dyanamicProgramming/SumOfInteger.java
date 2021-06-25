package dyanamicProgramming;
import java.util.Scanner;

public class SumOfInteger {
	
	static int count(int n, int[] numList) {
		
		int[] c = new int[n+1];
		c[0] = 1;
		
		for(int i=1; i<numList[0]; i++) {
			c[i] = 0;
		}
		
		for(int i=numList[0]; i<=n; i++) {
			for(int x : numList) {
				if(i>=x) {
					c[i] += c[i-x];
				}
				else {
					break;
				}
			}
		}
		return c[n];
	}
	
	static int count2(int n, int k) {
		
		int[][] c = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				
				if(j==1 || i==0) {
					c[i][j] = 1;
				}
				else if(i<j) {
					c[i][j] = c[i][i];
				}
				else {
					c[i][j] = c[i-j][j]+c[i][j-1];
				}
			}
		}
		return c[n][k];
	}
	

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int s = sc.nextInt();
		
		/*
		int[] sArray = new int[s];
		for(int i=0; i<s; i++) {
			sArray[i] = sc.nextInt();
		}*/
		
		System.out.println(count2(n, s));


		
	}
}