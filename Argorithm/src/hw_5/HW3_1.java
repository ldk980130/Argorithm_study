package hw_5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HW3_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*****************입력 받기***************************/
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		LinkedList<Integer>[] graph = new LinkedList[n]; //역 인접리스트
		for(int i=0; i<n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
		
		int start = sc.nextInt();
		int dest = sc.nextInt();
		/***************************************************/
		
		boolean[] visited = new boolean[n];
		
		System.out.println(bfs(graph, start, dest, visited));
	}
	
	static int bfs(LinkedList<Integer>[] graph, int start, int dest, boolean[] visited) {
		
		Queue<Integer> stationQ = new LinkedList<>();
		Queue<Integer> countQ = new LinkedList<>();
		
		stationQ.add(start);
		countQ.add(0);
		
		while(!stationQ.isEmpty()) {
			
			int station = stationQ.poll();
			int count = countQ.poll();
			
			if(station == dest) {
				return count;
			}
			
			visited[station] = true;
			
			Iterator<Integer> iter = graph[station].iterator();
			while(iter.hasNext()) {
				
				int temp = iter.next();
				if(!visited[temp]) {
					stationQ.add(temp);
					countQ.add(count+1);
				}
			}
		}
		return -1;
	}
}
