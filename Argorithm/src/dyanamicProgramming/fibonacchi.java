package dyanamicProgramming;
import java.io.*;
import java.util.Arrays;
public class fibonacchi {
	

	static int fiboMemorization(int n, int[] table) {
		
		if(table[n] != -1) {
			return table[n];
		}
		else {
			if(n==0 || n==1) {
				return n;
			}
			else {
				table[n] = fiboMemorization(n-1, table) + fiboMemorization(n-2, table);
				return table[n];
			}
		}
	}
	
	static int fiboBottomup(int n) {
		
		if(n<=1) {
			return n;
		}
		
		else {
			int[] table = new int[n+1];
			table[0] = 0;
			table[1]= 1;
			
			for(int i=2; i<=n; i++) {
				table[i] = table[i-1] + table[i-2];
			}
			
			return table[n];
		}
		
	}
	
	static int fibo(int n) { // 효율적 메모리 사용
		if(n<=1) {
			return n;
		}
		
		int current = 1;
		int prev = 1;
		int prev_prev = 0;
		
		for(int i=2; i<=n; i++) {
			current = prev + prev_prev;
			prev_prev = prev;
			prev = current;	
		}
		return current;
	}
	


	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] table = new int[n+1];
		Arrays.fill(table, -1);
		

		
	}

}
