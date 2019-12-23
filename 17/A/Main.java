import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n, int k) {
		int count = 0;
		int currentPrime = 2;
		while (true) {
			int nextPrime = findNextPrime(currentPrime);
			int sum = currentPrime + nextPrime + 1;
			if (sum > n) {
				break;
			}

			if (isPrime(sum)) {
				count++;
			}

			currentPrime = nextPrime;
		}

		return count >= k;
	}

	static int findNextPrime(int currentPrime) {
		for (int i = currentPrime + 1;; ++i) {
			if (isPrime(i)) {
				return i;
			}
		}
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; ++i) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}
