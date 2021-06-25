package sort;

import java.util.Scanner;

public class RadixSort {
	static int getMax(int[] data) {
		int mx = data[0];
		for(int i=1; i<data.length; i++) {
			if(data[i] > mx) {
				mx = data[i];
			}
		}
		return mx;
	}
	
	static void countingSort(int[] data, int exp) {
		
		int[] sorted = new int[data.length];
		int[] cnt = new int[10];
		
		for(int i=0; i<data.length; i++) {
			cnt[(data[i]/exp)%10]++;
		}
		for(int i=1; i<10; i++) {
			cnt[i] += cnt[i-1];
		}
		for(int i=data.length-1; i>=0; i--) {
			sorted[cnt[(data[i]/exp)%10]-1] = data[i];
			cnt[(data[i]/exp)%10]--;
		}
		for(int i=0; i<data.length; i++) {
			data[i] = sorted[i];
		}
	}
	
	static void radixsort(int[] data) {
		
		int m = getMax(data);
		for(int exp=1; m/exp>0; exp*=10) {
			countingSort(data, exp);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		radixsort(arr);
		
		for (int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}

}
