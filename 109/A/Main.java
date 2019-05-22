import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		for (int i = 0; i * 4 <= n; i++) {
			if ((n - i * 4) % 7 == 0) {
				return String.format("%s%s", repeat('4', i), repeat('7', (n - i * 4) / 7));
			}
		}
		return "-1";
	}

	static String repeat(char ch, int count) {
		return IntStream.range(0, count).mapToObj(i -> ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
