package graph;

import java.util.LinkedList;

public class Graph { //인접행렬로 표현
	int size;
	
	public Graph(int size) {
		this.size = size;
	}
	
	int[][] adjMatrix = new int[size][size];
	
	public void insertEdge(int v1, int v2) {
		adjMatrix[v1][v2] = 1;
		//무향그래프일 때
		adjMatrix[v2][v1] = 1;
	}
}

class GraphList{ //인접리스트
	int size;
	LinkedList<Integer>[] nodes;
	
	public GraphList(int size) {
		this.size = size;
		nodes = new LinkedList[size];
		
		for(int i=0; i<size; i++) {
			nodes[i] = new LinkedList<>();
		}
	}
	
	public void insertEdege(int v1, int v2) {
		nodes[v1].add(v2);
		//무향그래프일 때
		nodes[v2].add(v1);
	}
}