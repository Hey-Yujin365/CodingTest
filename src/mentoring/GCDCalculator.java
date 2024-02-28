package mentoring;

import java.util.Scanner;

public class GCDCalculator {

    // 유클리드 호제법을 사용하여 최대 공약수를 구하는 메서드
    public static int findGCD1(int a, int b) {
    	// 최대공약수를 구할 때까지 반복처리하기
        while (b != 0) {
        	// 먼저 b를 임의의 변수를 선언하고 담아둔다.
            int temp = b;
            // a % b 로 몫을 b에 담는다. 만약 여기서 0이 된다면 나누어 떨어졌다는 의미고 최대공약수가 구해진 것이다.
            b = a % b;
            // 임의의 변수에 담아두었던 수를 a에 담아준다.
            a = temp;
        }
        // b == 0이 된다면 return값으로 최대공약수인 a를 반환한다.
        return a;
    }
    
    // 재귀 함수를 사용하여 팩토리얼을 계산하는 메서드
    public static int findGCD2(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD2(b, a % b);
        }
    }

    public static void main(String[] args) {
    	// 기본 해결 방법
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 두 정수를 입력받기
        System.out.print("첫 번째 정수를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.print("두 번째 정수를 입력하세요: ");
        int num2 = scanner.nextInt();

        // 기본 해결 방법으로 최대 공약수 계산
        int gcd = findGCD1(num1, num2);

        // 재귀함수로 최대 공약수 계산
        int gcd2 = findGCD2(num1, num2);
        
        // 결과 출력
        System.out.println("기본 해결 방법으로 구한 최대 공약수: " + gcd);
        
        // 결과 출력
        System.out.println("재귀함수를 이용한 최대 공약수: " + gcd2);
        
        // 메모리 누수 방지
        scanner.close();
    }
}