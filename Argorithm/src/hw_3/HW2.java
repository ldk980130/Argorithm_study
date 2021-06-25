package hw_3;

import java.util.Scanner;


class Person{
	int arriveTime;
	int checkTime;
	int absoluteArrive=0;
	int waitTime;
}

public class HW2 {
	
	static void rebuildHeap(int[] arr, int r, int n) {
		//�ּ� �� �����
		int current = r;
		while(2*current+1 < n) {
			int leftChild = 2*current+1;
			int rightChild = 2*current+2;
			int smallChild;
			if(rightChild<n && arr[rightChild]<arr[leftChild]) {
				smallChild = rightChild;
			}
			else {
				smallChild = leftChild;
			}
			if(arr[current] > arr[smallChild]) {
				swap(arr, current, smallChild);
				current = smallChild;
			}
			else {
				break;
			}
		}
	}
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		Person[] person = new Person[n];
		
		for(int i=0; i<n; i++) {
			person[i] = new Person();
			person[i].arriveTime = sc.nextInt();
			person[i].checkTime = sc.nextInt();
			
		}
		for(int i=1; i<n; i++) {
			person[i].absoluteArrive = person[i-1].absoluteArrive+person[i].arriveTime;
		}
		
		int[] kTable = new int[k];
		int waitting = 0;
		Person[] waitList = new Person[n];
		int time = 0;
		int turn = 0;
		int listIn = 0;
		int listOut = 0;
		
/***************************************************************************************/	
		while(turn<n) {
			
			/**��ٸ��� ��� ���� �־��ֱ�**/
			while(waitting>0 && kTable[0]<=0) {
				waitting--;
				int keep = kTable[0];
				kTable[0] = waitList[listOut].checkTime+keep;
				rebuildHeap(kTable, 0, k);
				waitList[listOut].waitTime = keep+time-waitList[listOut].absoluteArrive;
				listOut++;
			}
			for(int i=0; i<k; i++) {
				if(kTable[i]<0) {
					kTable[i] = 0;
				}
			}
			/**���� �ð��� ������ ��� �ɻ�� ������ ��ٸ��� ����**/
			if(kTable[0]==0) {
				
				kTable[0] = person[turn].checkTime;
				rebuildHeap(kTable, 0, k);
				person[turn].waitTime = 0;
			}
			else {
				waitList[listIn] = person[turn];
				listIn++;
				waitting++;
			}
			
			turn++; 
			/**�� �� ��� ������ break**/
			if(turn>=n) {
				break;
			}
			
			/**�ð�����**/
			time += person[turn].arriveTime;
			for(int i=0; i<k; i++) {
				kTable[i] -= person[turn].arriveTime;
			}
		}
		
		/**�� �� ��� ���� ��ٸ��� ��� ���� ��**/
		while(waitting>0) {
			
			/**�ð�����**/
			time += kTable[0];
			for(int i=1; i<k; i++) {
				kTable[i] -= kTable[0];
			}
			
			/**��ٸ��� �ִ� ��� �ֱ�**/
			kTable[0] = waitList[listOut].checkTime;
			rebuildHeap(kTable,0,k);
			waitList[listOut].waitTime = time-waitList[listOut].absoluteArrive;
			listOut++;
			waitting--;
		}
		
		double sum = 0;
		for(int i=0; i<n; i++) {
			sum += person[i].waitTime;
		}
		System.out.printf("%.1f", sum/n);
	}

}
