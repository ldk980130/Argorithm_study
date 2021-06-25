package sort;

import java.util.Scanner;

public class MergeSort {

	static void mergeSort(int[] arr, int left, int right) {
		
		if(left<right) {
			
			int mid = (left+right)/2;
			
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	
	static void merge(int[] arr, int left, int mid, int right) {
		
		int i = left;
		int j = mid+1;
		int k = left;
		int[] sorted = new int[arr.length];
		
		while(i<=mid && j<=right) {
			
			if(arr[i] <= arr[j]) {
				sorted[k] = arr[i];
				i++;
			}
			else {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}
		/*
		if(i <= mid) {
			for(int t=i; t<=mid; t++) {
				sorted[k] = arr[t];
				k++;
			}
		}
		else if(j<=right) {
			for(int t=j; t<=right; t++) {
				sorted[k] = arr[t];
				k++;
			}
		}
		*/
		
		while(i<=mid) {
			sorted[k] = arr[i];
			i++;
			k++;
		}
		while(j<=right) {
			sorted[k] = arr[j];
			j++;
			k++;
		}
		
		for(int a=left; a<=right; a++) {
			arr[a] = sorted[a];
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		mergeSort(arr, 0, n-1);
		
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
}
