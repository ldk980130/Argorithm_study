package greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	@Override
	public int compareTo(Meeting o) {
		if(this.end==o.end) {
			return this.start-o.start;
		}
		else {
			return this.end - o.end;
		}
	}
}

public class MeetingRoom {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Meeting[] meeting = new Meeting[n]; 
		for(int i=0; i<n; i++) {
			meeting[i] = new Meeting();
			meeting[i].start = sc.nextInt();
			meeting[i].end = sc.nextInt();
		}
		Arrays.sort(meeting);
		
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		
		int answer = 1;
		for(int i=1; i<n; i++) {
			
			if(meeting[i].start>=meeting[stack.peek()].end) {
				answer++;
				stack.add(i);
			}
		}
		System.out.println(answer);
	}
}

