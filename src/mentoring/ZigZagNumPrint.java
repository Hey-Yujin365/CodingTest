package mentoring;

import java.util.Scanner;

public class ZigZagNumPrint {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ����ڷκ��� ����� ���� ���� �Է� �ޱ�
        System.out.print("�� ���ο� ����� ���� ����: ");
        int numbersPerLine = scanner.nextInt();

        // ���� ���� �Է� �ޱ�
        System.out.print("���� ����: ");
        int finalNumber = scanner.nextInt();

        // �� ���
        int rows = (int) Math.ceil((double) finalNumber / numbersPerLine);

        // ���� ���
        printZigZagNumbers(rows, numbersPerLine, finalNumber);
        
        // �޸� ���� ����
        scanner.close();
    }

    // ������� �������� ���� ����ϴ� �޼���
	private static void printZigZagNumbers(int rows, int numbersPerLine, int finalNumber) {
		int[][] matrix = new int[rows][numbersPerLine];
		int currentNumber = 1;

		// �� �ݺ�
		for (int row = 0; row < rows; row++) {
			// ¦�� ���� ���ʿ��� ���������� ä���
			if (row % 2 == 0) {
				for (int col = 0; col < numbersPerLine; col++) {
					matrix[row][col] = currentNumber++;
				}
			}
			// Ȧ�� ���� �����ʿ��� �������� ä���
			else {
				for (int col = numbersPerLine - 1; col >= 0; col--) {
					matrix[row][col] = currentNumber++;
				}
			}
		}

        // ��� ���
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < numbersPerLine; col++) {
                // ���� ���ڱ����� ����ϰ� �������� ���� ó��
                if (matrix[row][col] <= finalNumber) {
                    System.out.printf("%-5d", matrix[row][col]);
                } else {
                    System.out.print("     ");
                }
            }
            System.out.println(); // ���� �������� �Ѿ��
        }
    }
}
