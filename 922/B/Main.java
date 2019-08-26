import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		return IntStream.rangeClosed(1, n).map(a -> (int) IntStream.rangeClosed(a, n).filter(b -> {
			int c = a ^ b;

			return c >= b && c <= n && a + b > c;
		}).count()).sum();
	}
}
