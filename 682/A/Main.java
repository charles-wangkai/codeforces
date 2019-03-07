import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static long solve(int n, int m) {
		return IntStream.range(0, 5).mapToLong(i -> (long) computeModFiveNum(i, n) * computeModFiveNum((5 - i) % 5, m))
				.sum();
	}

	static int computeModFiveNum(int modulus, int limit) {
		return limit / 5 + ((modulus != 0 && modulus <= limit % 5) ? 1 : 0);
	}
}
