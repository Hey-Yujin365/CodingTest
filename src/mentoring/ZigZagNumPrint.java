package mentoring;

import java.util.Scanner;

public class ZigZagNumPrint {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 출력할 숫자 갯수 입력 받기
        System.out.print("한 라인에 출력할 숫자 갯수: ");
        int numbersPerLine = scanner.nextInt();

        // 최종 숫자 입력 받기
        System.out.print("최종 숫자: ");
        int finalNumber = scanner.nextInt();

        // 행 계산
        int rows = (int) Math.ceil((double) finalNumber / numbersPerLine);

        // 숫자 출력
        printZigZagNumbers(rows, numbersPerLine, finalNumber);
        
        // 메모리 누수 방지
        scanner.close();
    }

    // 지그재그 패턴으로 숫자 출력하는 메서드
	private static void printZigZagNumbers(int rows, int numbersPerLine, int finalNumber) {
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
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < numbersPerLine; col++) {
                // 최종 숫자까지만 출력하고 나머지는 공백 처리
                if (matrix[row][col] <= finalNumber) {
                    System.out.printf("%-5d", matrix[row][col]);
                } else {
                    System.out.print("     ");
                }
            }
            System.out.println(); // 다음 라인으로 넘어가기
        }
    }
}
