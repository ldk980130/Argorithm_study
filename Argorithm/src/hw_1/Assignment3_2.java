package hw_1;
import java.io.*;
public class Assignment3_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputArray = br.readLine().split(" ");
		
		int n = Integer.parseInt(input);
		int arr[] = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(inputArray[i]);
		}
		
		int count = 0; // �������� ���� �� ��
		int maxCount = 0; // �������� ���� �� ���� �ִ밪
		
		for (int i=0; i<n-1; i++)
		{
			// 1. ������ �������� ���� ������ count�� 1������
			if (arr[i] < arr[i+1])
			{
				count++;
			}
			// 2. ������ �������� count 0���� �ʱ�ȭ
			else
			{
				count = 0;
			}
			// 3. count ���� �ִ�� ���ŵ� ������ maxCount ����
			if (count > maxCount)
			{
				maxCount = count;
			}
		}
		System.out.println(maxCount);
	}
}
