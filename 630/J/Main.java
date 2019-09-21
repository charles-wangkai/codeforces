import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(long n) {
		return n / IntStream.rangeClosed(2, 10).reduce(1, Main::lcm);
	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
