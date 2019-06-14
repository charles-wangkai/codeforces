import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(int n, int k) {
		if (k > n) {
			return 0;
		}

		return C(n, k) * P(n, k);
	}

	static int factorial(int x) {
		return IntStream.rangeClosed(1, x).reduce(1, (a, b) -> a * b);
	}

	static int P(int n, int k) {
		return factorial(n) / factorial(n - k);
	}

	static int C(int n, int k) {
		return P(n, k) / factorial(k);
	}
}
