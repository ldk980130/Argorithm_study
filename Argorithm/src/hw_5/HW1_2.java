package hw_5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class HW1_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*****************입력 받기***************************/
		String[] mn = br.readLine().split(" ");
		int m = Integer.parseInt(mn[0]);
		int n = Integer.parseInt(mn[1]);
		
		String[] temp = new String[m];
		char[][] maze = new char[m][n];
		for(int i=0; i<m; i++) {
			temp[i] = br.readLine();
			maze[i] = temp[i].toCharArray();
		}
		/***************************************************/
		
		int answer = m*n;
		
		for(int i=0; i<n; i++) {
			if(maze[0][i]=='1') { //입구에 진입 가능
				boolean[][] visited = new boolean[m][n];
				
				int count = bfs(maze, 0, i, m, n, visited);
				
				if(count != -1 && count<answer) { //가는 길이 있고 경로 길이가 더 작으면 answer에 저장
					answer = count;
				}
				
			}
		}
		
		System.out.println((answer==m*n)?-1:answer);

	}
	
	
	static int bfs(char[][] maze, int row, int col, int m, int n, boolean[][]visited) {
		
		Queue<Integer> rowQ = new LinkedList<>();
		Queue<Integer> colQ = new LinkedList<>();
		Queue<Integer> countQ = new LinkedList<>();
		
		rowQ.add(row);
		colQ.add(col);
		countQ.add(1);
		
		while(!colQ.isEmpty()) {
			
			int r = rowQ.poll();
			int c = colQ.poll();
			int count = countQ.poll();
			
			
			if(r==m-1) {
				
				return count;
			}
			
			if(r<m-1 && maze[r+1][c]=='1' && !visited[r+1][c]) { // 아래쪽
				rowQ.add(r+1);
				colQ.add(c);
				countQ.add(count+1);
				visited[r+1][c] = true;
			}
			
			if(c<n-1 && maze[r][c+1]=='1' && !visited[r][c+1]) { // 오른쪽
				rowQ.add(r);
				colQ.add(c+1);
				countQ.add(count+1);
				visited[r][c+1] = true;
			}
			
			if(c>0 && maze[r][c-1]=='1' && !visited[r][c-1]) { // 왼쪽
				rowQ.add(r);
				colQ.add(c-1);
				countQ.add(count+1);
				visited[r][c-1] = true;
			}
			
			if(r>0 && maze[r-1][c]=='1' && !visited[r-1][c]) { //위쪽
				rowQ.add(r-1);
				colQ.add(c);
				countQ.add(count+1);
				visited[r-1][c] = true;
			}
		}
		
		return -1;
	}
}
