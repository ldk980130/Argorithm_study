package hw_5;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class HW2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*****************입력 받기***************************/
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		LinkedList<Integer>[] graph = new LinkedList[m]; // 친구관계 인접리스트
		
		for(int i=0; i<m; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x); 
		}
		/***************************************************/
		
		boolean[] checked = new boolean[m];
		LinkedList<Integer> nums = new LinkedList<>();
		
		int groups=0;
		
		for(int i=0; i<m; i++) {
			if(!checked[i]) {
				groups++;
				nums.add(dfs(i, graph, checked, 0));
			}
		}
		Collections.sort(nums);
		
		System.out.println(groups);
		System.out.print(nums.getLast()+" "+nums.getFirst());
	}
	
	static int dfs(int v, LinkedList<Integer>[] graph, boolean[] checked, int num) {
		checked[v] = true;
		num++;
		Iterator<Integer> iter = graph[v].iterator();
		
		while(iter.hasNext()) {
			v = iter.next();
			if(!checked[v]) {
				num = dfs(v, graph, checked, num);
			}
		}
		return num;
	}
}
