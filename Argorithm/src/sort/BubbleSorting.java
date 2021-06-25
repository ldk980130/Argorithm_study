package sort;
import java.util.Scanner;

public class BubbleSorting {

	static void bubbleSort(int[] arr, int n) {
		
		
		for (int i=n-1; i>=0; i--) {
			
			boolean sorted = true;
			
			for(int j=0; j<i; j++) {
				
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			if(sorted) {
				break;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		bubbleSort(arr, n);
		
		for (int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}

}
