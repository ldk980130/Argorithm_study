package hw_3;

import java.util.Scanner;

public class HW1_2 {
	
	static int findRoute(int[] price) {
		
		int[] minPrice = new int[price.length]; 
		int n = price.length-1;
		
		for(int i=1; i<=n; i++) {
			
			if(i==1 || i==3 || i==4) {
				minPrice[i] = price[i];
			}
			else if(i==2) {
				minPrice[i] = price[i]+minPrice[i-1];
			}
			else {
				int a = Math.min(minPrice[i-1], minPrice[i-3]);
				int b = Math.min(minPrice[i-3], minPrice[i-4]);
				minPrice[i] = Math.min(a, b)+price[i];
			}	
		}
		return minPrice[n];	
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] price = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			price[i] = sc.nextInt();
		}
		
		int output = findRoute(price);
		
		System.out.println(output);
		
	}

}
