package hw_1;
import java.io.*;

public class Assignment2_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputArray = br.readLine().split(" ");
		
		int n = Integer.parseInt(input);
		int arr[] = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(inputArray[i]);
		}
			
			int shareCount = 0; // �����ֽ� ����
			int expense = 0; // ����
			int profit = 0; // ����
			int maxPrice; // ���� �ȿ����� �ִ� ����
			int sellPoint = 0; //�ŵ�����(����Ʈ�� �ε�����)
			int buyPoint = 0; // �ż�����(����Ʈ�� �ε�����)
			boolean hasNext = true; // ����Ʈ �� ���� �����ϸ� false�� �ٲ�
			
			// 1. ����Ʈ�� ���� ���� ���� ���� ��� �ݺ��� ������.
			while (hasNext)
			{
				maxPrice = arr[buyPoint]; // �ִ밡���� �ż����� �������� �ʱ�ȭ
			// 2. �ż��������� ������ �� �ִ� ������ Ž��
				for (int j=buyPoint; j<n; j++)
				{
					if (arr[j] >= maxPrice)
					{
						maxPrice = arr[j];
						sellPoint = j; //�ִ밡���� �ε����� �ŵ������� ����
					}
				}
				// �ŵ����� �������� ����Ʈ���� ������ hasNext�� false�� ����
				if (sellPoint+1 == n)
				{
					hasNext = false;
				}
				// ���� �ŵ������� �ż������� ������ ���� �������� �ʰ� �ݺ����� ���ư�
				if (sellPoint == buyPoint)
				{
					buyPoint++; // �ż����� �� ĭ �ڷ� ����
					continue;
				}
			// 3. ���ͻ���
				// 3-1. �ż��������� �ŵ����� ������ 1�־� ���� �ż�
				for (int j=buyPoint; j<sellPoint; j++)
				{
					expense += arr[j];
					shareCount++;
				}
				// 3-2. ������ �ֽ� �ŵ������� ���� �ŵ�, ���� ���
				profit += shareCount*arr[sellPoint] - expense;
				buyPoint = sellPoint + 1; // �ż����� �ŵ����� �������� �̵�
				shareCount = 0; // �����ֽ� �������� ����
				expense = 0; // ���⵵ �����
			}
			// 4. ��� ���
			System.out.println(profit);
			
		}
}


