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
		
		int maxPrice; // 최대가격
		int minPrice; // 최소가격
		int searchStart = 0; // 최대,최소가격 탐색할 때 시작 인덱스값
		int searchEnd = n; // 최대, 최소가격 탐색할 때 끝 인덱스값
		int purchasePoint = 0; // 최대 이익을 낼 수 있는 매수가격 인덱스
		int sellPoint = arr[0]; // 최대 이익을 낼 수 있는 매도가격 인덱스
		int purchasePrice = arr[0]; // 최대 이익을 낼 수 있는 매수가격
		int sellPrice = 0; // 최대 이익을 낼 수 있는 매도가격
		int maxProfit = 0; // 얻을 수 있는 최대 이익
		
		while (true)
		{	// 최대, 최소가격을 searchStart로 초기화
			maxPrice = arr[searchStart];
			minPrice = arr[searchStart];
			// 1. searchStart부터 끝까지 중 최대가격 탐색
			for (int i=searchStart; i<n; i++)
			{
				if (arr[i] >= maxPrice)
				{
					maxPrice = arr[i];
					sellPoint = i;
					searchEnd = i;
				}
			}
			// 2. 처음부터 최대가격 전 값까지 중 최소가격 탐색
			for (int i=0; i<searchEnd; i++)
			{
				if (arr[i] <= minPrice)
				{
					minPrice = arr[i];
					purchasePoint = i;
				}
			}
			// 3-1. 최대가격 - 최소가격이 최대이익보다 크면 최대이익 수정하고 매도,매수가격 수정 
			if (maxProfit < (maxPrice-minPrice))
			{
				maxProfit = maxPrice-minPrice;
				purchasePrice = arr[purchasePoint];
				sellPrice = arr[sellPoint];
			}
			// 3-2. 최대이익이 나오는 경우가 여러개일 경우 매수가격이 작은 경우를 저장
			else if (maxProfit == maxPrice-minPrice)
			{
				if (minPrice < purchasePrice)
				{
					purchasePrice = arr[purchasePoint];
					sellPrice = arr[sellPoint];
				}
			}
			// 4-1. searchEnd가 배열의 끝에 도달하면 break
			if (searchEnd == n-1)
			{
				break;
			}
			//4-2. 탐색이 끝나지 않았으면 searchStart를 searchEnd 다음값으로 수정 
			searchStart = searchEnd + 1;
		}
		// 6. 결과 출력
		if (maxProfit == 0) 
		{
			System.out.println(-1); // 이익을 얻지 못했으면 -1 출력
		}
		else
		{
			System.out.println(maxProfit);
			System.out.printf("%d %d", purchasePrice, sellPrice);
		}
	}	
}
