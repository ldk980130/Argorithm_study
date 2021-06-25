package graph;

import java.util.LinkedList;

public class Graph { //������ķ� ǥ��
	int size;
	
	public Graph(int size) {
		this.size = size;
	}
	
	int[][] adjMatrix = new int[size][size];
	
	public void insertEdge(int v1, int v2) {
		adjMatrix[v1][v2] = 1;
		//����׷����� ��
		adjMatrix[v2][v1] = 1;
	}
}

class GraphList{ //��������Ʈ
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
		//����׷����� ��
		nodes[v2].add(v1);
	}
}