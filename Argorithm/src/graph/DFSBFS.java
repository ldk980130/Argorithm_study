package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS {

	public static void main(String[] args) {
		
	}
	
	static void dfs(LinkedList<Integer>[] graph, int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v+" ");
		
		Iterator<Integer> iter = graph[v].iterator();
		
		while(iter.hasNext()) {
			int next = iter.next();
			
			if(!visited[next]) {
				dfs(graph, next, visited);
			}
		}
	}
	
	static void bfs(LinkedList<Integer>[] graph, int v, boolean[] visited) {
		
		Queue<Integer> nextQ = new LinkedList<Integer>();
		
		nextQ.add(v);
		visited[v] = true;
		
		while(!nextQ.isEmpty()) {
			
			int w = nextQ.poll();
			System.out.print(w+" ");
			
			Iterator<Integer> iter = graph[w].iterator();
			
			while(iter.hasNext()) {
				int next = iter.next();
				if(!visited[next]) {
					nextQ.add(next);
					visited[next] = true;
				}
			}
		}
	}

}
