import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int MODULUS = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		return subtractMod(powMod(27, n), powMod(7, n));
	}

	static int powMod(int base, int exponent) {
		return IntStream.range(0, exponent).map(i -> base).reduce(1, Main::multiplyMod);
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}

	static int subtractMod(int x, int y) {
		return (x - y + MODULUS) % MODULUS;
	}
}
