package hw_2;

import java.util.Scanner;
public class HW3_2 {
	
	static void changeTime(int[] arr, int n) {
		
		if (n!=0) {
			int sum=0;
			for (int i=n; i>=0; i--) {
				sum += arr[i];
			}
			arr[n] = sum;
			changeTime(arr, n-1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arriveTime = new int[n];
		int[] checkTime = new int[n];
		int max = 0;
		
		for(int i=0; i<n; i++) {
			arriveTime[i] = sc.nextInt();
			checkTime[i] = sc.nextInt();
			max += checkTime[i];
		}
		
		changeTime(arriveTime, n-1);
		
		int[] waitTime = new int[n];
		
		int time = 0;
		int arriveCheck = 0;
		int extract = 0;
		int k1=0;
		int k2=0;
		int waitting = 0;
		
		while (time < max) { // time이 1분씩 늘어간다
			
			if (waitting>0) { // 이미 도착했지만 기다리고 있는 인원이 있을 때
							  // 심사대에 자리가 나면 넣어준다
				if(k1==0) {
					k1 = checkTime[extract];
					waitTime[extract] = time-arriveTime[extract];
					// 이 때 지금 time에서 도착시간을 빼주면 기다린 시간이 된다
					extract++;
					waitting--;
					
					if (k2==0) {
						continue;
					}
				}
				else if(k2==0) {
					k2 = checkTime[extract];
					waitTime[extract] = time-arriveTime[extract];
					extract++;
					waitting--;
					
					if (k1==0) {
						continue;
					}
				}
			}
			
			if (arriveCheck < n) { 
				// 아직 더 올 사람이 있을 때 심사대에 자리가 나면 넣어준다
				if (time==arriveTime[arriveCheck]) {
					if (k1==0) {
						k1 += checkTime[extract];
						waitTime[extract] = time-arriveTime[extract];
						extract++;
					}
					else if(k2==0) {
						k2 += checkTime[extract];
						waitTime[extract] = time-arriveTime[extract];
						extract++;
					}
					else {
						waitting++;
					}
					arriveCheck++;
				}
			}
			// 더 올 사람이 있을 때
			if (arriveCheck<n && arriveTime[arriveCheck] != arriveTime[arriveCheck-1]) {
				// 각 심사대 1분씩 빼고 time 1분 추가
				if (k1 > 0) {
					k1--;
				}
				if (k2>0) {
					k2--;
				}
				time++;
			}
			// 더 올 사람이 없을 때
			else if(arriveCheck>=n) {
				// 기다리는 사람이 있으면 각 심사대에 1분씩 빼고 time을 1분 넘기고 다음 반복으로
				if(waitting>0) {
					
					if (k1 > 0) {
						k1--;
					}
					if (k2>0) {
						k2--;
					}
					time++;
				}
				// 기다리는 사람이 없으면 반복 빠져나오기
				else if(waitting==0) {
					break;
				}
			}
		}
		
		float sum = 0;
		// 평균 구하기
		for (int i:waitTime) {
			sum += i;
		}
		System.out.printf("%.1f", sum/n);	
	}
}
