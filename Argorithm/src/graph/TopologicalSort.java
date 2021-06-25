package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
	
	static void topologicalSort(LinkedList<Integer>[] graph, int[] indegree, int n) {
		
		Queue<Integer> nodeQ = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			if(indegree[i]==0) {
				nodeQ.add(i);
			}
		}
		while(!nodeQ.isEmpty()) {
			int v = nodeQ.poll();
			System.out.print(v+" ");
			
			Iterator<Integer> iter = graph[v].iterator();
			while(iter.hasNext()) {
				int w = iter.next();
				indegree[w]--;
				if(indegree[w]==0) {
					nodeQ.add(w);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		LinkedList<Integer>[] graph = new LinkedList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new LinkedList<>();
		}
		
		int[] indegree = new int[n+1]; //진입분지수
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			indegree[y]++;
		}
		
		topologicalSort(graph, indegree, n);
	}
}
