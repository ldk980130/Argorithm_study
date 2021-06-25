package sort;

import java.util.Scanner;

public class HeapSort {

	static void heapSort(int[] arr, int n) {
		
		for(int i=n/2-1; i>=0; i--) {
			rebuildHeap(arr, i, n);
		}
		
		int size = n;
		
		for(int i=n-1; i>0; i--) {
			swap(arr, i, 0);
			size--;
			rebuildHeap(arr, 0, size);
		}
	}
	
	static void rebuildHeap(int[] arr, int r, int n) {
		
		int current = r;
		
		while(2*current+1 < n) {
			int leftChild = 2*current+1;
			int rightChild = 2*current+2;
			int largeChild;
			
			if(rightChild<n && arr[rightChild]>arr[leftChild]) {
				largeChild = rightChild;
			}
			else {
				largeChild = leftChild;
			}
			
			if(arr[current] < arr[largeChild]) {
				swap(arr, current, largeChild);
				current = largeChild;
			}
			else {
				break;
			}
		}
	}
	
	
	
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		heapSort(arr, n);
		
		for (int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}

}
