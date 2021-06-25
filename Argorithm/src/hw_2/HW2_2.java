package hw_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

class Pair{
	int smallNum;
	int largeNum;
}

public class HW2_2 {
	static int distance = 1000000000;
	static int index = 0;
	
	static int binarySearch(int[] arr, int left, int right, int k) {
		
		if (left <= right) {
			int mid = (left+right)/2;
			if (k == arr[mid]) { 
				distance = 0;
				index = mid;
			}
			
			else if (k < arr[mid]) {
				if (Math.abs(arr[mid]-k) == Math.abs(distance)) {
					if ((arr[mid]-k) < distance) {
						distance = arr[mid]-k;
						index = mid;
					}
				}
				else if (Math.abs(arr[mid]-k) < Math.abs(distance)) {
					distance = arr[mid]-k;
					index = mid;
				}
				
				binarySearch(arr, left, mid-1, k);
			}
			
			else {
				if (Math.abs(arr[mid]-k) == Math.abs(distance)) {
					
					if ((arr[mid]-k) < distance) {
						distance = arr[mid]-k;
						index = mid;
					}
				}
				
				if (Math.abs(arr[mid]-k) < Math.abs(distance)) {
					distance = arr[mid]-k;
					index = mid;
				}
				
				binarySearch(arr, mid+1, right, k);
			}
		}
		return index;
	}
	
	static void quickSort(int[] arr, int left, int right) {
		
		if (left<right) {
			
			int newPoint = partition(arr, left,right);
			
			quickSort(arr, left, newPoint-1);
			quickSort(arr, newPoint+1,right);
		}
		
	}
	static int partition(int arr[], int left, int right) {
		Random ran = new Random();
		int point = ran.nextInt(right-left) + left;
		swap(arr, left, point);
		
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
	
	
	static Pair searchPair(int[] arr, int point, int s) {
		Pair pair = new Pair();
		int i = point;
		int j = point+1;
		int distance = 1000000000;
		
		while (i>=0) {
			if (i == arr.length-1) {
				i--;
				j--;
			}
			if (arr[i]+arr[j] == s) {
				pair.smallNum = arr[i];
				pair.largeNum = arr[j];
				break;
			}
			else if(arr[i]+arr[j] < s) {
				
				if (s-(arr[j]+arr[i]) < distance) {
					pair.smallNum = arr[i];
					pair.largeNum = arr[j];
					distance = s-(arr[j]+arr[i]);
				}
				j++;
			}
			else if(arr[i]+arr[j] > s) {
				j = point;
				i--;
			}
			if(j>arr.length-1) {
				j = point;
				i--;
			}
		}
		return pair;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = Integer.parseInt(br.readLine());
		
		quickSort(arr, 0, arr.length-1);
		
		int point = binarySearch(arr, 0, arr.length-1, s/2);
		
		Pair pair = searchPair(arr, point, s);
		

		System.out.printf("%d %d", pair.smallNum, pair.largeNum);
		
	}

}
