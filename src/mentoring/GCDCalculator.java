package mentoring;

public class GCDCalculator {

    // 유클리드 호제법을 사용하여 최대 공약수를 구하는 메서드
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
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
        // 두 수 입력
        int num1 = 48;
        int num2 = 18;

        // 최대 공약수 계산
        int gcd = findGCD(num1, num2);

        // 결과 출력
        System.out.println("최대 공약수: " + gcd);
        
        // 두 수 입력
        int num3 = 924;
        int num4 = 32;

        // 최대 공약수 계산
        int gcd2 = findGCD2(num3, num4);

        // 결과 출력
        System.out.println("최대 공약수: " + gcd2);
    }
}