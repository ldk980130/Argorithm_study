package graph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class WeightedDAGLongPath {
	
	static void findLongestPath(LinkedList<Node>[] graph, int v, int t, boolean[] visited, int[] longestLen) {
		visited[v] = true;
		
		if(v==t) {
			longestLen[v] = 0;
			return;
		}
		
		Iterator<Node> iter = graph[v].iterator();
		while(iter.hasNext()) {
			Node w = iter.next();
			
			if(!visited[w.end]) {
				findLongestPath(graph, w.end, t, visited, longestLen);
				longestLen[v] = Math.max(longestLen[v], w.weight+longestLen[w.end]);
			}
			else {
				longestLen[v] = Math.max(longestLen[v], w.weight+longestLen[w.end]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		LinkedList<Node>[] graph = new LinkedList[n];
		for(int i=0; i<n; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			
			graph[x].add(new Node(y, w));
		}
		
		int v = sc.nextInt();
		int t = sc.nextInt();
		
		boolean[] visited = new boolean[n];
		int[] longestLen = new int[n];
		
		findLongestPath(graph, v, t, visited, longestLen);
		
		System.out.println(longestLen[v]);
	}

}
