package hw_1;
import java.io.*;
public class Assignment1_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] inputArray = br.readLine().split(" ");
		int n = Integer.parseInt(input);
		int arr[] = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(inputArray[i]);
		}
		
		int maxPrice; // �ִ밡��
		int minPrice; // �ּҰ���
		int searchStart = 0; // �ִ�,�ּҰ��� Ž���� �� ���� �ε�����
		int searchEnd = n; // �ִ�, �ּҰ��� Ž���� �� �� �ε�����
		int purchasePoint = 0; // �ִ� ������ �� �� �ִ� �ż����� �ε���
		int sellPoint = arr[0]; // �ִ� ������ �� �� �ִ� �ŵ����� �ε���
		int purchasePrice = arr[0]; // �ִ� ������ �� �� �ִ� �ż�����
		int sellPrice = 0; // �ִ� ������ �� �� �ִ� �ŵ�����
		int maxProfit = 0; // ���� �� �ִ� �ִ� ����
		
		while (true)
		{	// �ִ�, �ּҰ����� searchStart�� �ʱ�ȭ
			maxPrice = arr[searchStart];
			minPrice = arr[searchStart];
			// 1. searchStart���� ������ �� �ִ밡�� Ž��
			for (int i=searchStart; i<n; i++)
			{
				if (arr[i] >= maxPrice)
				{
					maxPrice = arr[i];
					sellPoint = i;
					searchEnd = i;
				}
			}
			// 2. ó������ �ִ밡�� �� ������ �� �ּҰ��� Ž��
			for (int i=0; i<searchEnd; i++)
			{
				if (arr[i] <= minPrice)
				{
					minPrice = arr[i];
					purchasePoint = i;
				}
			}
			// 3-1. �ִ밡�� - �ּҰ����� �ִ����ͺ��� ũ�� �ִ����� �����ϰ� �ŵ�,�ż����� ���� 
			if (maxProfit < (maxPrice-minPrice))
			{
				maxProfit = maxPrice-minPrice;
				purchasePrice = arr[purchasePoint];
				sellPrice = arr[sellPoint];
			}
			// 3-2. �ִ������� ������ ��찡 �������� ��� �ż������� ���� ��츦 ����
			else if (maxProfit == maxPrice-minPrice)
			{
				if (minPrice < purchasePrice)
				{
					purchasePrice = arr[purchasePoint];
					sellPrice = arr[sellPoint];
				}
			}
			// 4-1. searchEnd�� �迭�� ���� �����ϸ� break
			if (searchEnd == n-1)
			{
				break;
			}
			//4-2. Ž���� ������ �ʾ����� searchStart�� searchEnd ���������� ���� 
			searchStart = searchEnd + 1;
		}
		// 6. ��� ���
		if (maxProfit == 0) 
		{
			System.out.println(-1); // ������ ���� �������� -1 ���
		}
		else
		{
			System.out.println(maxProfit);
			System.out.printf("%d %d", purchasePrice, sellPrice);
		}
	}	
}
