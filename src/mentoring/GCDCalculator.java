package mentoring;

import java.util.Scanner;

public class GCDCalculator {

    // 최대공약수 구하는 기본 해결 방법
    public static int findGCD(int a, int b) {
        // 두 수 중 작은 수 찾기
        int min = Math.min(a, b);

        // 최대공약수를 저장할 변수 선언 및 초기화
        int gcd = 1;

        // 작은 수부터 시작하여 최대공약수 갱신
        for (int i = 2; i <= min; i++) {
        	// 나머지를 0으로 만드는 공약수인지 판정한다.
            if (a % i == 0 && b % i == 0) {
            	// 조건문을 통과한 숫자는 공약수로 판정되어 gcd에 대입된다.
            	// for문을 이용해서 i는 1씩 증가하게 되고, 두 수 중 작은 수까지 증가한 후 마지막에 들어가있는 숫자가 최대공약수가 된다.
                gcd = i;
            }
        }

        // 최대공약수 반환
        return gcd;
    }
	
    /*
     * 	유클리드 호제법으로 최대공약수를 구할 때 두 수를 받아 큰수를 작은수로 나누기를 반복하게 된다.
     * 	두 수를 나누다가 나머지가 0이되게 만드는 그 숫자가 최대 공약수가 되는 것인데,
     *  의문 점 1. 두 수를 입력받을 것인데 큰 수, 작은 수 입력 순서와 상관 없이 원하는 값을 얻을 수 있는가?
     *   답 : 어떤 순서로 넣어도 최종결과값은 원하는 수를 얻을 수 있다.
     *   만약 18과 48을 순서대로 넣으면
     *   gcd(18, 48)에서 (b 값으로 전달받았던 48, 18%48=18)로 다음 호출은 gcd(48, 18)로 자리가 바뀐 값이 전달 된다.
     *   그 후엔 (18, 48%18) 즉 (18,12)가 매개변수로 전달된다.
     *  고로 두 수의 크기를 비교해서 순서대로 넣어주는 과정은 필요없다.
     */
    public static int findGCD1(int a, int b) {
    	// 큰수%작은수가 0이면 최대공약수가 구해진 것이다.
    	// 이를 판단하기 위해 작은수가 0인지 구한다.
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
    
    // 재귀 함수를 사용하여 최대공약수를 구하는 메소드
    // 위에서 사용한 유클리드 호제법을 재귀함수로 간단히 나타낸 것이다.
    public static int findGCD2(int bigNum, int smallNum) {
        if (smallNum == 0) {
            return bigNum;
        } else {
            return findGCD2(smallNum, bigNum % smallNum);
        }
    }

    public static void main(String[] args) {
    	// 입력받기 위해 스캐너 함수 사용
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 두 정수를 입력받기
        System.out.print("첫 번째 정수를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.print("두 번째 정수를 입력하세요: ");
        int num2 = scanner.nextInt();

        // 기본 해결 방법으로 최대 공약수 계산
        int gcd = findGCD(num1, num2);
        
        // 유클리드 호제법으로 최대 공약수 계산
        int gcd1 = findGCD1(num1, num2);

        // 재귀함수로 최대 공약수 계산
        int gcd2 = findGCD2(num1, num2);
        
        // 결과 출력
        System.out.println("기본 해결 방법으로 구한 최대 공약수: " + gcd);
        
        System.out.println("유클리드호제 해결 방법으로 구한 최대 공약수: " + gcd1);
        
        System.out.println("재귀함수를 이용한 최대 공약수: " + gcd2);
        
        // 메모리 누수 방지
        scanner.close();
    }
}