package hw_2;

import java.util.Scanner;
public class HW1 {
	static long squareMod(long c,int k, int n) {
		if (k==0) {
			return 1%n;
		}
		else if (k == 1) {
			return c % n;
		}
		else {
			if (k%2==0) { // (a2/k mod n)2 mod n
				long tmp = squareMod(c, k/2, n);
				return (tmp*tmp)%n;
			}
			else { // (a*(ak-1 mod n)) mod n
				return (c*squareMod(c, k-1, n))%n;
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int e = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt();
		
		long c = squareMod(m,e,n);
		long output = squareMod(c,d,n);
		
		System.out.println(c);
		System.out.println(output);
		
	}

}
