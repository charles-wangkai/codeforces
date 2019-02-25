import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n, int m) {
		return IntStream.range(n + 1, m).allMatch(x -> !isPrime(x)) && isPrime(m);
	}

	static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}
