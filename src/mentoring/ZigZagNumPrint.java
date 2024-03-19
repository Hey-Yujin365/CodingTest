package mentoring;

import java.util.Scanner;

public class ZigZagNumPrint {
	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        // ����ڷκ��� ����� ���� ���� �Է� �ޱ�
        System.out.print("�� ���ο� ����� ���� ����: ");
        int numbersPerLine = scanner.nextInt();

        // ����� ������ ���� �Է� �ޱ�
        System.out.print("������ ����: ");
        int finalNumber = scanner.nextInt();

        // �� ���
        // ���� ����� ���� �Ҽ����� �־�� �ϱ� ������ double������ ����ȯ�� �� (����� ������ ����/�ึ�� ����� ����)�� ����Ѵ�.
        // double������ ��ȯ�� ����� ���ڸ� ceil�Լ��� �ø� �Ѵ�.(õ�尪�� ���ϴ� �Լ���.)
        // �׷��� ���� ���� �ٽ� int������ �� ���� ��Ÿ���� rows ������ ��´�.
        int rows = (int) Math.ceil((double) finalNumber / numbersPerLine);

        // ������� ������ ����ϱ� ���� 2���� �迭�� �����.
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
		// �� ��� �ݺ�
        for (int row = 0; row < rows; row++) {
        	// �� ��� �ݺ�
            for (int col = 0; col < numbersPerLine; col++) {
                // ���� ���ڱ����� ����ϰ� �������� ���� ó��
                if (matrix[row][col] <= finalNumber) {
                	// %-5d�� ����� ������ ������ ������ ���ʺ��� 5ĭ�� �����ϰڴٴ� �ǹ̴�
                    System.out.printf("%-5d", matrix[row][col]);
                } else {
                    System.out.print("     ");
                }
            }
            System.out.println(); // ���� �������� �Ѿ��
        }
        
        // �޸� ���� ����
        scanner.close();
    }
}
