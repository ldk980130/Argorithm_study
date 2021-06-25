package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class MinSpanningTree {
	
	static int prim(List<Node>[] graph, int v) {
		int minWeight = 0;
		LinkedList<Integer> s = new LinkedList<>();
		boolean[] visited = new boolean[v+1];
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1, 0));
		
		while(!queue.isEmpty()) {
			Node minWeightNode = queue.poll();
			
			if(visited[minWeightNode.end]) continue;
			visited[minWeightNode.end] = true;
			
			s.add(minWeightNode.end);
			minWeight += minWeightNode.weight;
			if(s.size()==v) {
				break;
			}
			
			Iterator<Node> iter = graph[minWeightNode.end].iterator();
			while(iter.hasNext()) {
				Node nextNode = iter.next();
				queue.add(nextNode);
			}
		}
		return minWeight;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		List<Node>[] graph = new List[v+1];
		for(int i=1; i<=v; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i=0; i<e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			
			graph[x].add(new Node(y, w));
			graph[y].add(new Node(x, w));
		}
		
		System.out.println(prim(graph, v));
	}
}


