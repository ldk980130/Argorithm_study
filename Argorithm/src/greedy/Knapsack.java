package greedy;

import java.util.Arrays;
import java.util.Scanner;

class Item implements Comparable<Item>{
	float p;
	float w;

	@Override
	public int compareTo(Item o) {
		if(o.p/o.w>this.p/this.w) {
			return 1;
		}
		else if(o.p/o.w<this.p/this.w) {
			return -1;
		}
		else {
			return 0;
		}
	}
}

public class Knapsack {
	
	static float knapsack(Item[] item, float m, int n) {
		// item은 p/w기준 내림차순 정렬되어 있음
		float[] x = new float[n];
		int i=0;
		float sum=0;
		
		while(item[i].w<=m && i<n) {
			x[i] = 1;
			m -= item[i].w;
			i++;
		}
		if(i<n) {
			x[i] = m/item[i].w;
		}
		
		for(int j=0; j<n; j++) {
			sum += item[j].p*x[j];
		}
		return sum;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		float m = sc.nextInt();
		
		Item[] item = new Item[n];
		
		for(int i=0; i<n; i++) {
			item[i] = new Item();
			item[i].p = sc.nextFloat();
		}
		for(int i=0; i<n; i++) {
			item[i].w = sc.nextFloat();
		}
		
		Arrays.sort(item);
		
		System.out.println(knapsack(item, m, n));
	}

}
