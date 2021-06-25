package hw_5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Station{
	String name;
	boolean visited = false;
	
	public Station(String name) { // �� �̸�
		this.name = name;
	}
	
	private HashSet<Integer> lineSet = new HashSet<>(); //ȯ�� �����̿��� ȣ�� �������� ��츦 ���
	
	public void addLineSet(int line) {
		lineSet.add(line);
	}
	
	public HashSet<Integer> getLineSet() {
		return lineSet;
	}
	
	private LinkedList<Station> next = new LinkedList<>(); //������ �� ��� ��ũ�帮��Ʈ
	
	public void addNext(Station station) {
		next.add(station);
	}
	
	public LinkedList<Station> getNext(){
		return next;
	}
	
}

public class HW3_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		/*****************�Է� �ޱ�***************************/
		int m = sc.nextInt();
		
		HashMap<String, Station> map = new HashMap<>(); // ���̸����� �ش� �� Ŭ������ ã�� �� �ְ�
		
		for(int i=0; i<m; i++) {
			int line = sc.nextInt();
			String station1 = sc.next();
			String station2 = sc.next();
			
			if(!map.containsKey(station1)) { //���� �ȵ� ���̸� ����
				map.put(station1, new Station(station1));
			}
			if(!map.containsKey(station2)) {
				map.put(station2, new Station(station2));
			}
			map.get(station1).addNext(map.get(station2)); // ������� ����
			map.get(station2).addNext(map.get(station1));
			
			map.get(station1).addLineSet(line); // ��ȣ������
			map.get(station2).addLineSet(line);
		}
		
		String start = sc.next();
		String dest = sc.next();
		/***************************************************/
		
		String answer = bfs(map, start, dest);
		if(!answer.equals("-1")) {
			System.out.println(answer.split(" ").length);
		}
		System.out.println(answer);

	}
	
	static String bfs(HashMap<String, Station> map, String start, String dest) {
		
		Queue<String> stationQ = new LinkedList<>(); //�� ���� ť
		Queue<String> coseQ = new LinkedList<>(); // ��� ���� ť
		Queue<Integer> transferQ = new LinkedList<>(); //�� �ڽ��� ȯ�� Ƚ�� ���� ť
		
		Queue<String> minCoseQ = new LinkedList<>();// ���� �ּ� ��� ������ �����ϴ� ť
		 
		Queue<Integer> transferCheck = new LinkedList<>(); //ȯ�� Ƚ�� �� ���� ť
		
		Queue<HashSet<Integer>> prevLineQ = new LinkedList<>(); 
		// ���� ���� ���� ���� ��ȣ���� ������ �ִ��� �����ϴ� ť
		
		stationQ.add(start);
		coseQ.add(start+" ");
		transferQ.add(0);
		prevLineQ.add(map.get(start).getLineSet());
		
		while(!stationQ.isEmpty()) {
			
			String station = stationQ.poll(); // ���� ��
			String cose = coseQ.poll(); // ������� �ڽ�
			int transfer = transferQ.poll(); // ���翪���� ȯ�� Ƚ��
			HashSet<Integer> prevLineSet = prevLineQ.poll(); // ���� ���� ��ȣ���� ������ �ִ���
			
			map.get(station).visited = true; // �湮 �Ϸ�
			
			if(station.equals(dest)) { // �������� ����
				if(minCoseQ.isEmpty()) {
					minCoseQ.add(cose); 
					transferCheck.add(transfer);
				}
				else if(minCoseQ.peek().split(" ").length==cose.split(" ").length){
					minCoseQ.add(cose); 
					transferCheck.add(transfer);
				}
				else {
					break; // �ּ� ��ΰ� �ƴϸ� break
				}
			}
			
			Iterator<Station> iter = map.get(station).getNext().iterator();
			while(iter.hasNext()) { // ���� �� ��ȸ
				Station temp = iter.next();
				
				if(!temp.visited) {
					stationQ.add(temp.name); // ���� �� �߰�
					coseQ.add(cose+temp.name+" "); // ���� �ڽ� �߰�
					prevLineQ.add(map.get(station).getLineSet());
					// ���� ���� �������̴ϱ� ���� ���� ��ȣ������ �־���
					
					/*ȯ�¿��� üũ*/
					HashSet<Integer> tempLineSet = new HashSet<>();
					tempLineSet.addAll(prevLineSet);
					HashSet<Integer> nextLineSet = temp.getLineSet();
					
					//���翪 ���� �������� �������� ���� �ٸ� ȣ���� ������ ������ ȯ���Ѱ�
					tempLineSet.retainAll(nextLineSet); 
					if(tempLineSet.isEmpty()) {
						transferQ.add(transfer+1);
					}
					else {
						transferQ.add(transfer);
					}
				}
			}
		}
		
		if(minCoseQ.size()==0) { // ���������� ���� ����� ����
			return "-1";
		}
		else {
			int min = transferCheck.poll();
			String cose = minCoseQ.poll();
			int count = cose.split(" ").length;
			
			while(!minCoseQ.isEmpty()) { // ȯ�� Ƚ�� ���� ���� �ڽ� ����
				int transferTemp = transferCheck.poll();
				String coseTemp = minCoseQ.poll();
				
				if(min> transferTemp) {
					min = transferTemp;
					cose = coseTemp;
				}
			}
			return cose;
		}
	}
	
	

}
