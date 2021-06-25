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
		
		int count = 0; // 연속으로 오른 날 수
		int maxCount = 0; // 연속으로 오른 날 수의 최대값
		
		for (int i=0; i<n-1; i++)
		{
			// 1. 지수가 연속으로 오를 때마다 count를 1씩증가
			if (arr[i] < arr[i+1])
			{
				count++;
			}
			// 2. 지수가 떨어지면 count 0으로 초기화
			else
			{
				count = 0;
			}
			// 3. count 값이 최대로 갱신될 때마다 maxCount 수정
			if (count > maxCount)
			{
				maxCount = count;
			}
		}
		System.out.println(maxCount);
	}
}
