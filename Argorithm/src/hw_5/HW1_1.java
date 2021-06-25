package hw_5;

import java.util.Arrays;
import java.util.Scanner;

public class HW1_1 {

	public static void main(String[] args) {
		/*****************�Է� �ޱ�***************************/
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		String[] temp = new String[m];
		char[][] maze = new char[m][n];
		
		boolean[][] visited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			temp[i] = sc.next();
			maze[i] = temp[i].toCharArray();
		}
		/***************************************************/
		
		int answer = -1; // �����
		
		for(int i=0; i<n; i++) {
			if(maze[0][i]=='1') { // ù��° �ٿ��� 1�� ã�� �� Ž��
				if(dfs(maze, 0, i, m, n, visited)==1) { //���� ���� ������ answer 1�� ����
					answer = 1;
					break;
				}
				
				for(int j=0; j<m; j++) {
					Arrays.fill(visited[j], false); //���� ���� ��ã������ �湮�� false�� �ʱ�ȭ
				}	
			}
		}
		
		System.out.println(answer);
	}
	
	static int dfs(char[][] maze, int row, int col, int m, int n, boolean[][] visited) {
		
		visited[row][col] = true;
		
		if(row==m-1) { // ����
			return 1;
		}
		
		if(col<n-1) { // ������
			if(maze[row][col+1]=='1' && visited[row][col+1]==false){
				if(dfs(maze, row, col+1, m, n, visited)==1) {
					return 1;
				}
			}
		}
		if(row<m-1) { // �Ʒ���
			if(maze[row+1][col]=='1' && visited[row+1][col]==false) {
				if(dfs(maze, row+1, col, m, n, visited)==1) {
					return 1;
				}
			}
		}
		if(col>0) { // ����
			if(maze[row][col-1]=='1' && visited[row][col-1]==false) {
				if(dfs(maze, row, col-1, m, n, visited)==1) {
					return 1;
				}
			}
		}
		if(row>0 ) {
			if(maze[row-1][col]=='1' && visited[row-1][col]==false) {
				if(dfs(maze, row-1, col, m, n, visited)==1) {
					return 1;
				}
			}
		}
		return -1;
	}
}
