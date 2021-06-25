package hw_2;

import java.util.Scanner;

public class HW3_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arriveTime = new int[n];
		int[] checkTime = new int[n];
		
		for(int i=0;i<n;i++) {
			arriveTime[i] = sc.nextInt();
			checkTime[i] = sc.nextInt();
		}
		
		int[] waitTime = new int[n];
		
		float sum = 0;
		waitTime[0] = 0;
		
		for(int i=1; i<n; i++) {
			// Wk = Wk-1 – Ak + Ck-1 (공식 적용)
			waitTime[i] = waitTime[i-1] - arriveTime[i] + checkTime[i-1];
			if (waitTime[i] < 0) {
				waitTime[i] = 0;
			}
			sum += waitTime[i];
		}
		
		System.out.printf("%.1f", sum/n);
	}
}
