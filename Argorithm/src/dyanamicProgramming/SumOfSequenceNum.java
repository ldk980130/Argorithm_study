package dyanamicProgramming;

import java.util.Scanner;

public class SumOfSequenceNum{
	
	static int sumOfSequenceNum(int[] num) {
		
		int n = num.length;
		int[] sum = new int[n];
		
		for(int i=0; i<n; i++) {
			
			if(i==0) {
				sum[i] = num[i];
			}
			
			else if(sum[i-1]>0) {
				sum[i] = sum[i-1]+num[i];
			}
			else {
				sum[i] = num[i];
			}
		}
		
		int max = sum[0];
		for (int i=0; i<n; i++) {
			if(max<sum[i]) {
				max = sum[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		System.out.println(sumOfSequenceNum(arr));
	}
}

