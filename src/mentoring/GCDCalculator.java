package mentoring;

import java.util.Scanner;

public class GCDCalculator {

    // ��Ŭ���� ȣ������ ����Ͽ� �ִ� ������� ���ϴ� �޼���
    public static int findGCD1(int a, int b) {
    	// �ִ������� ���� ������ �ݺ�ó���ϱ�
        while (b != 0) {
        	// ���� b�� ������ ������ �����ϰ� ��Ƶд�.
            int temp = b;
            // a % b �� ���� b�� ��´�. ���� ���⼭ 0�� �ȴٸ� ������ �������ٴ� �ǹ̰� �ִ������� ������ ���̴�.
            b = a % b;
            // ������ ������ ��Ƶξ��� ���� a�� ����ش�.
            a = temp;
        }
        // b == 0�� �ȴٸ� return������ �ִ������� a�� ��ȯ�Ѵ�.
        return a;
    }
    
    // ��� �Լ��� ����Ͽ� ���丮���� ����ϴ� �޼���
    public static int findGCD2(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD2(b, a % b);
        }
    }

    public static void main(String[] args) {
    	// �⺻ �ذ� ���
        Scanner scanner = new Scanner(System.in);

        // ����ڷκ��� �� ������ �Է¹ޱ�
        System.out.print("ù ��° ������ �Է��ϼ���: ");
        int num1 = scanner.nextInt();

        System.out.print("�� ��° ������ �Է��ϼ���: ");
        int num2 = scanner.nextInt();

        // �⺻ �ذ� ������� �ִ� ����� ���
        int gcd = findGCD1(num1, num2);

        // ����Լ��� �ִ� ����� ���
        int gcd2 = findGCD2(num1, num2);
        
        // ��� ���
        System.out.println("�⺻ �ذ� ������� ���� �ִ� �����: " + gcd);
        
        // ��� ���
        System.out.println("����Լ��� �̿��� �ִ� �����: " + gcd2);
        
        // �޸� ���� ����
        scanner.close();
    }
}