package recursion;

import java.util.Scanner;

public class BinarySearch {

	static int binarySearch(int[] arr, int key) {
		
		int first = 0;
		int last = arr.length-1;
		
		while(first<=last) {
			
			int mid = (first+last)/2;
			
			if(arr[mid] == key) {
				return mid;
			}
			else if(arr[mid] < key) {
				last = mid-1;
			}
			else {
				first = mid+1;
			}
		}
		return -1;
	}
	
	static int binaryRecursionSearch(int[] arr, int key, int left, int right) {
		
		if(left<=right) {
			int mid = (left+right)/2;
			
			if(arr[mid] == key) {
				return mid;
			}
			
			else if(arr[mid] < key) {
				binaryRecursionSearch(arr, key, left, mid-1);
			}
			else {
				binaryRecursionSearch(arr, key, mid+1, right);
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int key = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int index = binaryRecursionSearch(arr, key, 0, n-1);
		
		System.out.println(index);
	}

}
