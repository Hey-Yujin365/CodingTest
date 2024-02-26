package mentoring;

//PrimeNumber 클래스 선언
public class PrimeNumber {
	/*
	 * findPrime 메소드는 에라토스테네스의 체 알고리즘을 사용하여 소수를 찾습니다.
	 * isPrime 배열은 각 숫자가 소수인지를 나타내는 배열로 초기에는 모든 수를 소수로 가정합니다.
	 * 두 번째 for 문에서 에라토스테네스의 체 알고리즘을 구현합니다.
	 */

	// 에라토스테네스의 체를 사용하여 소수를 찾는 메서드
	public static boolean[] findPrimes(int n) {
		// 각 숫자의 소수 여부를 나타내는 배열
		// isPrime[0] = true, isPrime[1] = true, isPrime[2] = false ...
		boolean[] isPrime = new boolean[n + 1];

		// 처음에 모든 수를 소수로 가정
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		// 에라토스테네스의 체 알고리즘
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

	// main 메서드: 프로그램의 시작점
	public static void main(String[] args) {
		// 소수를 찾을 범위 설정
		int n = 50;

		// 소수 찾기
		boolean[] primes = findPrimes(n);

		// 결과 출력
		System.out.println("1부터 " + n + "까지의 소수:");
		
		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				System.out.print(i + " ");
			}
		}
	}
}