package mentoring;

import java.util.Scanner;

public class ZigZagNumPrint {
	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 출력할 숫자 개수 입력 받기
        System.out.print("한 라인에 출력할 숫자 개수: ");
        int numbersPerLine = scanner.nextInt();

        // 출력할 마지막 숫자 입력 받기
        System.out.print("마지막 숫자: ");
        int finalNumber = scanner.nextInt();

        // 행 계산
        // 먼저 계산한 수에 소수점이 있어야 하기 때문에 double형으로 형변환한 뒤 (출력할 마지막 슛자/행마다 출력할 숫자)를 계산한다.
        // double형으로 변환해 계산한 숫자를 ceil함수로 올림 한다.(천장값을 구하는 함수다.)
        // 그렇게 나온 수를 다시 int형으로 행 수를 나타내는 rows 변수에 담는다.
        int rows = (int) Math.ceil((double) finalNumber / numbersPerLine);

        // 지그재그 패턴을 출력하기 위해 2차원 배열을 만든다.
		int[][] matrix = new int[rows][numbersPerLine];
		int currentNumber = 1;

		// 행 반복
		for (int row = 0; row < rows; row++) {
			// 짝수 행은 왼쪽에서 오른쪽으로 채우기
			if (row % 2 == 0) {
				for (int col = 0; col < numbersPerLine; col++) {
					matrix[row][col] = currentNumber++;
				}
			}
			// 홀수 행은 오른쪽에서 왼쪽으로 채우기
			else {
				for (int col = numbersPerLine - 1; col >= 0; col--) {
					matrix[row][col] = currentNumber++;
				}
			}
		}

        // 결과 출력
		// 행 출력 반복
        for (int row = 0; row < rows; row++) {
        	// 열 출력 반복
            for (int col = 0; col < numbersPerLine; col++) {
                // 최종 숫자까지만 출력하고 나머지는 공백 처리
                if (matrix[row][col] <= finalNumber) {
                	// %-5d는 출력할 형식을 지정한 것으로 왼쪽부터 5칸씩 차지하겠다는 의미다
                    System.out.printf("%-5d", matrix[row][col]);
                } else {
                    System.out.print("     ");
                }
            }
            System.out.println(); // 다음 라인으로 넘어가기
        }
        
        // 메모리 누수 방지
        scanner.close();
    }
}
