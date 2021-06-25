package graph;

public class DisjointSet {
	
	static int[] p;
	static int[] rank;
	
	static void makeSet(int x) {
		p[x] = x;
		rank[x] = 0;
	}
	
	static void Union(int x, int y) {
		
		int ax = findSet(x);
		int ay = findSet(y);
		
		if(rank[ax]>rank[ay]) {
			p[ay] = ax;
		}
		else {
			p[ax] = ay;
			if(rank[ax]==rank[ay]) rank[ay]++;
		}
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x] = findSet(p[x]);
		return p[x];
	}
	public static void main(String[] args) {
		
	}

}
