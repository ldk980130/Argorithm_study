package sort;

import java.io.*;

public class CountingSort {

	static int[] countingSort(int[] arr) {
		
		int max = getMax(arr);
		
		int n = arr.length;	
		int[] cnt = new int[max+1];
		int[] sorted = new int[n];
		
		// 배열 생성 시 0으로 초기화 됨
		
		for(int i=0; i<n; i++) {
			cnt[arr[i]]++;
		}
		
		for(int i=1; i<=max; i++) {
			cnt[i] += cnt[i-1];
		}
		
		for(int i=n-1; i>=0; i--) {
			sorted[cnt[arr[i]]-1] = arr[i];
			cnt[arr[i]]--;
		}
		
		return sorted;
	}
	
	static int getMax(int[] data) {
		int mx = data[0];
		for(int i=1; i<data.length; i++) {
			if(data[i] > mx) {
				mx = data[i];
			}
		}
		return mx;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] sorted = countingSort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			sb.append(sorted[i]).append('\n');
		}
		
		System.out.println(sb);
	}

}
