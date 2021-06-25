package hw_4;

import java.util.Scanner;

public class HW2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] u = new int[n+1];
		int[] l = new int[n+1];
		int[] uTol = new int[n];
		int[] lTou = new int[n];
		
		for(int i=0; i<=n; i++) {
			u[i] = sc.nextInt();
		}
		for(int i=0; i<=n; i++) {
			l[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			uTol[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			lTou[i] = sc.nextInt();
		}
		System.out.println(calTime(u, l, uTol, lTou));
	}
	
	static int calTime(int[] u, int[] l, int[] uTol, int[] lTou) {
		
		int timeU=0;
		int timeL=0;
		int minTime=0;
		int n = u.length;
		
		for(int i=0; i<n; i++) {
			
			if(i==0) {
				timeU = Math.min(u[i], l[i]+lTou[i]);
				timeL = Math.min(l[i], u[i]+uTol[i]);
			}
			else if(i==n-1) {
				
				minTime = Math.min(timeU+u[i], timeL+l[i]);
			}
			else {
				int tempU = Math.min(timeU+u[i], timeL+l[i]+lTou[i]);
				int tempL = Math.min(timeL+l[i], timeU+u[i]+uTol[i]);
				timeU = tempU;
				timeL = tempL;
			}
			
		}
		
		return minTime;
	}

}
