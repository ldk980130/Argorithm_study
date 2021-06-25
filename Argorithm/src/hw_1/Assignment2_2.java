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
			
			int shareCount = 0; // 보유주식 개수
			int expense = 0; // 지출
			int profit = 0; // 이익
			int maxPrice; // 범위 안에서의 최대 가격
			int sellPoint = 0; //매도시점(리스트의 인덱스값)
			int buyPoint = 0; // 매수시점(리스트의 인덱스값)
			boolean hasNext = true; // 리스트 끝 값에 도달하면 false로 바뀜
			
			// 1. 리스트의 다음 값이 있을 때는 계속 반복을 돌린다.
			while (hasNext)
			{
				maxPrice = arr[buyPoint]; // 최대가격을 매수시점 가격으로 초기화
			// 2. 매수시점부터 끝까지 중 최대 가격을 탐색
				for (int j=buyPoint; j<n; j++)
				{
					if (arr[j] >= maxPrice)
					{
						maxPrice = arr[j];
						sellPoint = j; //최대가격의 인덱스값 매도시점에 대입
					}
				}
				// 매도시점 다음날에 리스트값이 없으면 hasNext를 false로 변경
				if (sellPoint+1 == n)
				{
					hasNext = false;
				}
				// 만약 매도시점과 매수시점이 같으면 이익 저장하지 않고 반복으로 돌아감
				if (sellPoint == buyPoint)
				{
					buyPoint++; // 매수시점 한 칸 뒤로 수정
					continue;
				}
			// 3. 이익산출
				// 3-1. 매수시점부터 매도시점 전까지 1주씩 전부 매수
				for (int j=buyPoint; j<sellPoint; j++)
				{
					expense += arr[j];
					shareCount++;
				}
				// 3-2. 보유한 주식 매도시점에 전부 매도, 이익 계산
				profit += shareCount*arr[sellPoint] - expense;
				buyPoint = sellPoint + 1; // 매수시점 매도시점 다음날로 이동
				shareCount = 0; // 보유주식 남아있지 않음
				expense = 0; // 지출도 사라짐
			}
			// 4. 결과 출력
			System.out.println(profit);
			
		}
}


