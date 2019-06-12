import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int tc = 0; tc < N; tc++) {
			int number = sc.nextInt();

			System.out.println(solve(number) ? "Yes" : "No");
		}

		sc.close();
	}

	static boolean solve(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0 && isPrime(i) && isPrime(number / i)) {
				return true;
			}
		}
		return false;
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
