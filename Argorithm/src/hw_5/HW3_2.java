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
	
	public Station(String name) { // 역 이름
		this.name = name;
	}
	
	private HashSet<Integer> lineSet = new HashSet<>(); //환승 구간이여서 호선 여러개일 경우를 고려
	
	public void addLineSet(int line) {
		lineSet.add(line);
	}
	
	public HashSet<Integer> getLineSet() {
		return lineSet;
	}
	
	private LinkedList<Station> next = new LinkedList<>(); //인접한 역 담는 링크드리스트
	
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
		/*****************입력 받기***************************/
		int m = sc.nextInt();
		
		HashMap<String, Station> map = new HashMap<>(); // 역이름으로 해당 역 클래스를 찾을 수 있게
		
		for(int i=0; i<m; i++) {
			int line = sc.nextInt();
			String station1 = sc.next();
			String station2 = sc.next();
			
			if(!map.containsKey(station1)) { //생성 안된 역이면 생성
				map.put(station1, new Station(station1));
			}
			if(!map.containsKey(station2)) {
				map.put(station2, new Station(station2));
			}
			map.get(station1).addNext(map.get(station2)); // 연결관계 설정
			map.get(station2).addNext(map.get(station1));
			
			map.get(station1).addLineSet(line); // 몇호선인지
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
		
		Queue<String> stationQ = new LinkedList<>(); //역 저장 큐
		Queue<String> coseQ = new LinkedList<>(); // 경로 저장 큐
		Queue<Integer> transferQ = new LinkedList<>(); //각 코스별 환승 횟수 저장 큐
		
		Queue<String> minCoseQ = new LinkedList<>();// 최종 최소 경로 여러개 저장하는 큐
		 
		Queue<Integer> transferCheck = new LinkedList<>(); //환승 횟수 비교 위한 큐
		
		Queue<HashSet<Integer>> prevLineQ = new LinkedList<>(); 
		// 지금 역의 직전 역이 몇호선을 가지고 있는지 저장하는 큐
		
		stationQ.add(start);
		coseQ.add(start+" ");
		transferQ.add(0);
		prevLineQ.add(map.get(start).getLineSet());
		
		while(!stationQ.isEmpty()) {
			
			String station = stationQ.poll(); // 현재 역
			String cose = coseQ.poll(); // 현재까지 코스
			int transfer = transferQ.poll(); // 현재역까지 환승 횟수
			HashSet<Integer> prevLineSet = prevLineQ.poll(); // 직전 역이 몇호선을 가지고 있는지
			
			map.get(station).visited = true; // 방문 완료
			
			if(station.equals(dest)) { // 목적지에 도착
				if(minCoseQ.isEmpty()) {
					minCoseQ.add(cose); 
					transferCheck.add(transfer);
				}
				else if(minCoseQ.peek().split(" ").length==cose.split(" ").length){
					minCoseQ.add(cose); 
					transferCheck.add(transfer);
				}
				else {
					break; // 최소 경로가 아니면 break
				}
			}
			
			Iterator<Station> iter = map.get(station).getNext().iterator();
			while(iter.hasNext()) { // 인접 역 순회
				Station temp = iter.next();
				
				if(!temp.visited) {
					stationQ.add(temp.name); // 다음 역 추가
					coseQ.add(cose+temp.name+" "); // 다음 코스 추가
					prevLineQ.add(map.get(station).getLineSet());
					// 다음 역의 직전역이니까 지금 역이 몇호선인지 넣어줌
					
					/*환승여부 체크*/
					HashSet<Integer> tempLineSet = new HashSet<>();
					tempLineSet.addAll(prevLineSet);
					HashSet<Integer> nextLineSet = temp.getLineSet();
					
					//현재역 기준 직전역과 다음역이 전혀 다른 호선을 가지고 있으면 환승한것
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
		
		if(minCoseQ.size()==0) { // 목적지까지 가는 방법이 없음
			return "-1";
		}
		else {
			int min = transferCheck.poll();
			String cose = minCoseQ.poll();
			int count = cose.split(" ").length;
			
			while(!minCoseQ.isEmpty()) { // 환승 횟수 가장 적은 코스 리턴
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
