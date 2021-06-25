package sort;
import java.util.Scanner;

public class QuickSort {
	
	static void quickSort(int[] arr, int left, int right) {
		
		if (left<right) {
			int newPoint = partition(arr, left,right);
			quickSort(arr, left, newPoint-1);
			quickSort(arr, newPoint+1,right);
		}
		
	}
	
	
	static int partition(int arr[], int left, int right) {
		
		int pivot = arr[left];
		int i = left+1;
		int j = right;
		
		while (i<=j) {
			
			while (i<=right && arr[i]<pivot) {
				i++;
			}
			
			while (j>=left+1 && arr[j]>=pivot) {
				j--;
			}
			
			if (i<=j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		swap(arr, left, j);
		return j;
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
		
		quickSort(arr, 0, n-1);
		
		for(int i : arr) {
			System.out.println(i);
		}
		
	}

}
