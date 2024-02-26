package mentoring;

public class GCDCalculator {

    // ��Ŭ���� ȣ������ ����Ͽ� �ִ� ������� ���ϴ� �޼���
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
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
        // �� �� �Է�
        int num1 = 48;
        int num2 = 18;

        // �ִ� ����� ���
        int gcd = findGCD(num1, num2);

        // ��� ���
        System.out.println("�ִ� �����: " + gcd);
        
        // �� �� �Է�
        int num3 = 924;
        int num4 = 32;

        // �ִ� ����� ���
        int gcd2 = findGCD2(num3, num4);

        // ��� ���
        System.out.println("�ִ� �����: " + gcd2);
    }
}