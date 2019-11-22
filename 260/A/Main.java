import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(solve(a, b, n));

		sc.close();
	}

	static String solve(int a, int b, int n) {
		int base = findBase(a, b);
		if (base == -1) {
			return "-1";
		}

		return String.format("%d%s", base, IntStream.range(0, n - 1).map(i -> 0)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
	}

	static int findBase(int a, int b) {
		for (int i = 0; i <= 9; i++) {
			int base = a * 10 + i;

			if (base % b == 0) {
				return base;
			}
		}

		return -1;
	}
}
