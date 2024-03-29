package mentoring;

import java.util.Scanner;

//PrimeNumber 클래스 선언
public class PrimeNumber {
	/*
	 * findPrime 메소드는 에라토스테네스의 체 알고리즘을 사용하여 소수를 찾기
	 * isPrime 배열은 각 숫자가 소수인지를 나타내는 배열로 초기에는 모든 수를 소수로 가정한다.
	 */

	// 에라토스테네스의 체를 사용하여 소수를 찾는 메서드
	public static boolean[] findPrimes(int n) {
		// 각 숫자의 소수 여부를 나타내는 배열
		// isPrime[0] = true, isPrime[1] = true, isPrime[2] = false ...
		boolean[] isPrime = new boolean[n + 1];

		// 처음에 모든 수를 소수로 가정
		// 2부터 시작하는 이유는 소수의 의미가 1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수이고 1은 소수가 아니기 때문이다.
		for (int i = 2; i <= n; i++) {
			// 모든 수의 배열 안에 true 값을 넣어 소수로 가정한다.
			isPrime[i] = true;
		}

		// 에라토스테네스의 체 알고리즘
		// i의 배수에 해당하는 배열을 찾아 false로 만드는 작업을 한다.
		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				// i의 배수들을 소수에서 제외
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		// 최종적인 소수 여부를 담은 배열 반환
		return isPrime;
	}

	public static void main(String[] args) {
		// 소수 구할 범위 숫자를 입력받기 위해 scanner를 사용한다.
        Scanner scanner = new Scanner(System.in);
        
		// 소수를 찾을 범위 설정
        System.out.print("소수 구할 숫자 : ");
		int n = scanner.nextInt();

		// 소수 찾기
		boolean[] primes = findPrimes(n);

		// 결과 출력
		System.out.println("1부터 " + n + "까지의 소수:");
		
		// 반복문을 통해 배열에 담긴 소수를 출력한다.
		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				System.out.print(i + " ");
			}
		}
		scanner.close();
	}
}