package hw_2;

import java.util.Scanner;

public class HW2_1 {
	static int distance=1000000000;
	static int binarySearch(int[] arr, int left, int right, int k) {
		if (left <= right) {
			int mid = (left+right)/2;
			if (k == arr[mid]) { 
				distance = 0;
			}
			else if (k < arr[mid]) {
				if (Math.abs(arr[mid]-k) == Math.abs(distance)) {
					if ((arr[mid]-k) < distance) {
						distance = arr[mid]-k;
					}
				}
				else if (Math.abs(arr[mid]-k) < Math.abs(distance)) {
					distance = arr[mid]-k;
				}
				
				binarySearch(arr, left, mid-1, k);
			}
			else {
				if (Math.abs(arr[mid]-k) == Math.abs(distance)) {
					
					if ((arr[mid]-k) < distance) {
						distance = arr[mid]-k;
					}
				}
				
				if (Math.abs(arr[mid]-k) < Math.abs(distance)) {
					distance = arr[mid]-k;
				}
				
				binarySearch(arr, mid+1, right, k);
			}
		}
		return distance + k;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		
		int result = binarySearch(arr, 0, n-1, k);
		
		System.out.println(result);
	}
}
