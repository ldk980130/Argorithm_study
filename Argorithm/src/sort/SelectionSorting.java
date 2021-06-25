package sort;
import java.util.Scanner;

public class SelectionSorting {

	static void selectionSort(int[] arr, int n) {
		
		for(int i=n-1; i>=0; i--) {
			
			int index = 0;
			for(int j=0; j<=i; j++) {
				
				if(arr[index] < arr[j]) {
					index = j;
				}
			}
			int temp = arr[index];
			arr[index]= arr[i];
			arr[i] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		selectionSort(arr, n);
		
		for (int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}
}
