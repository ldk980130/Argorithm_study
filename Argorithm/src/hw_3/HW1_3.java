package hw_3;

import java.util.Scanner;

public class HW1_3{

	static int findRoute(int[] price, int[] s) {
		
		int[] minPrice = new int[price.length];
		
		for(int i=1; i<price.length; i++){
			
			if(i<s[0]){
				minPrice[i] = -1;
			}
			
			else if(i>=s[0]){
				int min = -1;
				for(int x : s){
					if(i-x>=0 && minPrice[i-x]!=-1){
						min = minPrice[i-x];
						break;
					}
				}
				for(int x : s){
					if(min==-1){break;}
					if(i-x>=0 && minPrice[i-x]!=-1 && minPrice[i-x]<min){
						min = minPrice[i-x];
					}
				}
				if(min==-1) {
					minPrice[i] = -1;
				}
				else {
					minPrice[i] = min + price[i];
				}
			}
				
		}
		return minPrice[price.length-1];
	
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] s = new int[k];
		for(int i=0; i<k; i++) {
			s[i] = sc.nextInt();
		}
		
		int[] price = new int[n+1];
		for(int i=1; i<=n; i++) {
			price[i] = sc.nextInt();
		}
		int output = findRoute(price, s);
		
		System.out.println(output);
	}

}
