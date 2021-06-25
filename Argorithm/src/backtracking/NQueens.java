package backtracking;

public class NQueens {
	static int answer = 0;
	static void nQueens(int[] x, int k, int n) {
		
		if(k==n) {
			answer++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			
			if(place(x, k, i)) {
				x[k] = i;
				nQueens(x, k+1, n);
			}
		}
	}
	static boolean place(int[]x, int k, int i) {
		for(int j=0; j<k; j++) {
			if(x[j]==i || Math.abs(x[j]-i)==Math.abs(j-k)) return false;
		}
		return true;
	}
}
