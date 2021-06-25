package backtracking;

import java.util.Scanner;

public class Permutation {
	static void permutation(int[] p, int k, int n, boolean[] used) {
		
		if(k<=n) {
			for(int i=1; i<=n; i++) {
				if(!used[i]) {
					p[k] = i;
					used[i] = true;
					
					if(k==n) {
						for(int j=1; j<=n; j++) {
							System.out.print(p[j]+" ");
						}
						System.out.println();
						used[i] = false;
						return;
					}
					
					permutation(p, k+1, n, used);
					used[i] = false;
				}
			}
		}
	}
	
	static void permutation2(int[] p, int k, int n, int r, boolean[] used) {
		
		if(k<=r) {
			for(int i=1; i<=n; i++) {
				if(!used[i]) {
					p[k] = i;
					used[i] = true;
					
					if(k==r) {
						for(int j=1; j<=r; j++) {
							System.out.print(p[j]+" ");
						}
						System.out.println();
						used[i] = false;
						continue;
					}
					
					permutation2(p, k+1, n, r, used);
					used[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean[] used = new boolean[n+1];
		int[] p = new int[n+1];
		permutation(p, 1, n, used);
	}
}
