package recursion;
import java.util.Scanner;

public class HanoiTower {
	
	static void hanoi(int n, int source, int dest, int temp) {
		
		if(n==1) {
			System.out.printf("%d에서 %d로 옮겨짐\n", source, dest);
		}
		
		else {
			hanoi(n-1, source, temp, dest);
			System.out.printf("%d에서 %d로 옮겨짐\n", source, dest);
			hanoi(n-1, temp, dest, source);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		hanoi(n, 1,3,2);
	}

}
