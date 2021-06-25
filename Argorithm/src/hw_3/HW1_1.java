package hw_3;

import java.util.Scanner;

public class HW1_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		
		if(n==1 || n==2) {
			
			System.out.println(1);
		}
		else if(n == 3) {
			
			System.out.println(2);
		}
		else {
			arr[0] = 1;
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 2;
			
			for(int i=4; i<=n; i++) {
				arr[i] = arr[i-1] + arr[i-3] + arr[i-4];
			}
			
			System.out.println(arr[n]);
		}
		
		
		
		
	}

}
