package greedy;

import java.util.Scanner;

public class CoinExchange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 동전 개수
		int k = sc.nextInt(); // 금액
		
		int[] coin = new int[n];
		for(int i=0; i<n; i++) {
			coin[i] = sc.nextInt(); //내림차순 정렬된 동전들
		}
		
		int count=0;
		int index = coin.length-1;
		while(index>=0) {
			
			if(k>=coin[index]) {
				int temp = k/coin[index];
				count += temp;
				k -= temp*coin[index];
			}
			index--;
		}
		
		System.out.println(count);
	}
}
