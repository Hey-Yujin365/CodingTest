package mentoring;

//PrimeNumber Ŭ���� ����
public class PrimeNumber {
	/*
	 * findPrime �޼ҵ�� �����佺�׳׽��� ü �˰����� ����Ͽ� �Ҽ��� ã���ϴ�.
	 * isPrime �迭�� �� ���ڰ� �Ҽ������� ��Ÿ���� �迭�� �ʱ⿡�� ��� ���� �Ҽ��� �����մϴ�.
	 * �� ��° for ������ �����佺�׳׽��� ü �˰����� �����մϴ�.
	 */

	// �����佺�׳׽��� ü�� ����Ͽ� �Ҽ��� ã�� �޼���
	public static boolean[] findPrimes(int n) {
		// �� ������ �Ҽ� ���θ� ��Ÿ���� �迭
		// isPrime[0] = true, isPrime[1] = true, isPrime[2] = false ...
		boolean[] isPrime = new boolean[n + 1];

		// ó���� ��� ���� �Ҽ��� ����
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		// �����佺�׳׽��� ü �˰���
		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				// i�� ������� �Ҽ����� ����
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		// �������� �Ҽ� ���θ� ���� �迭 ��ȯ
		return isPrime;
	}

	// main �޼���: ���α׷��� ������
	public static void main(String[] args) {
		// �Ҽ��� ã�� ���� ����
		int n = 50;

		// �Ҽ� ã��
		boolean[] primes = findPrimes(n);

		// ��� ���
		System.out.println("1���� " + n + "������ �Ҽ�:");
		
		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				System.out.print(i + " ");
			}
		}
	}
}