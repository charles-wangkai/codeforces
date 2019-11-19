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

	static long solve(int n, int k) {
		int pow10 = IntStream.range(0, k).reduce(1, (result, element) -> result * 10);

		return (long) pow10 / gcd(n, pow10) * n;
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
