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
		
		while (time < max) { // time�� 1�о� �þ��
			
			if (waitting>0) { // �̹� ���������� ��ٸ��� �ִ� �ο��� ���� ��
							  // �ɻ�뿡 �ڸ��� ���� �־��ش�
				if(k1==0) {
					k1 = checkTime[extract];
					waitTime[extract] = time-arriveTime[extract];
					// �� �� ���� time���� �����ð��� ���ָ� ��ٸ� �ð��� �ȴ�
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
				// ���� �� �� ����� ���� �� �ɻ�뿡 �ڸ��� ���� �־��ش�
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
			// �� �� ����� ���� ��
			if (arriveCheck<n && arriveTime[arriveCheck] != arriveTime[arriveCheck-1]) {
				// �� �ɻ�� 1�о� ���� time 1�� �߰�
				if (k1 > 0) {
					k1--;
				}
				if (k2>0) {
					k2--;
				}
				time++;
			}
			// �� �� ����� ���� ��
			else if(arriveCheck>=n) {
				// ��ٸ��� ����� ������ �� �ɻ�뿡 1�о� ���� time�� 1�� �ѱ�� ���� �ݺ�����
				if(waitting>0) {
					
					if (k1 > 0) {
						k1--;
					}
					if (k2>0) {
						k2--;
					}
					time++;
				}
				// ��ٸ��� ����� ������ �ݺ� ����������
				else if(waitting==0) {
					break;
				}
			}
		}
		
		float sum = 0;
		// ��� ���ϱ�
		for (int i:waitTime) {
			sum += i;
		}
		System.out.printf("%.1f", sum/n);	
	}
}
